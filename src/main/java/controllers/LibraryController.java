package controllers;

import db.DBHelper;
import db.Seed;
import models.Library;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.modelAndView;
import static spark.SparkBase.staticFileLocation;

public class LibraryController {

    public static void main(String[] args){
//        Seed.seedData();
        staticFileLocation("/public");
        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        get("/library", (req, res) -> {

            List<Library> libraries = DBHelper.getAll(Library.class);

            HashMap<String, Object> model = new HashMap<>();
            model.put("libraries", libraries);
            model.put("template", "templates/library/index.vtl");
            return modelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);
    }
}
