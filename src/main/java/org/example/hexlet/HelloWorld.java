package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        app.get("users/{id}/post/{postId}", ctx -> {
            var id = ctx.pathParamAsClass("id", Long.class).get();
            var postId = ctx.pathParamAsClass("postId", Long.class).get();

            ctx.result("users/" + id + "/post/" + postId);
        });

        app.start(7070);
    }
}