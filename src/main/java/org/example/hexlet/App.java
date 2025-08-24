package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.component.DataInitializer;
import org.example.hexlet.dao.CourseDAO;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static io.javalin.rendering.template.TemplateUtil.model;

public class App {
    private static Connection connection;

    public static void main(String[] args) throws Exception {

        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("H2 Driver not found", e);
        }

        connection = DriverManager.getConnection("jdbc:h2:mem:hexlet;DB_CLOSE_DELAY=-1");
        DataInitializer.init(connection);

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/courses/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Long.class).get();
            var courseDAO = new CourseDAO(connection);
            var course = courseDAO.findByID(id).orElseThrow(() ->
                    new RuntimeException("Course not found with id: " + id));
            var page = new CoursePage(course);
            ctx.render("courses/show.jte", model("page", page));
        });

        app.get("/courses", ctx -> {
            var courseDAO = new CourseDAO(connection);
            var courses = courseDAO.findAll();
            var header = "Курсы по программированию";
            var page = new CoursesPage(courses, header);
            ctx.render("index.jte", model("page", page));
        });

        app.events(event -> {
            event.serverStopping(() -> {
                try {
                    if (connection != null && !connection.isClosed()) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            });
        });

        app.start(7070);
    }
}