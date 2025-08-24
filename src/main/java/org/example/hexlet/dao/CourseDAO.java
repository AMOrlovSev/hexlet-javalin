package org.example.hexlet.dao;

import org.example.hexlet.model.Course;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseDAO {

    private final Connection connection;

    public CourseDAO(Connection conn) {
        connection = conn;
    }

    public Optional<Course> findByID (long id) throws SQLException {

        var sql = "SELECT * FROM courses WHERE id = ?";
        try (var stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            var resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                var name = resultSet.getString("name");
                var description = resultSet.getString("description");
                var course = new Course(name, description);
                course.setId(id);
                return Optional.of(course);
            }
            return Optional.empty();
        }
    }

    public List<Course> findAll() throws SQLException {

        var sql = "SELECT * FROM courses";
        try (var stmt = connection.createStatement()) {
            var resultSet = stmt.executeQuery(sql);
            List<Course> courses = new ArrayList<>();
            while (resultSet.next()) {
                var id = resultSet.getLong("id");
                var name = resultSet.getString("name");
                var description = resultSet.getString("description");
                var course = new Course(name, description);
                course.setId(id);
                courses.add(course);
            }
            return courses;
        }
    }
}

