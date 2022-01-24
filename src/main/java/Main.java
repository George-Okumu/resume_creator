import models.Resume;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        staticFileLocation("/public");

        // get welcome page
        get("/", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "welcome.hbs");

        }, new HandlebarsTemplateEngine());

        // get creator page
        get("/creator", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            return  new ModelAndView(model, "creator.hbs");
        }, new HandlebarsTemplateEngine());

        //post resume details
        post("/resume/new", (request, response) -> { //URL to make new post on POST route
            Map<String, Object> model = new HashMap<String, Object>();
            String title = request.queryParams("title");
            String companyName = request.queryParams("companyName");
            String location = request.queryParams("location");
            String description = request.queryParams("description");
            Resume resume = new Resume(title, companyName, location, description);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        // get all resumes
        get("resumes", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Resume> resumes = Resume.getResumeCreated();
            model.put("resumes", resumes);
            return new ModelAndView(model, "resumes.hbs");
        }, new HandlebarsTemplateEngine());

    }

}

