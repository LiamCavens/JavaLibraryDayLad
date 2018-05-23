package controllers;

import db.Seed;

import static spark.Spark.get;
import static spark.Spark.modelAndView;
import static spark.SparkBase.staticFileLocation;

public class LibraryController {

    public static void main(String[] args){
        Seed.seedData();

    }
}
