import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import models.ChangeMachine;
import spark.ModelAndView;
import static spark.Spark.*;
import spark.template.handlebars.HandlebarsTemplateEngine;


public class App {
    public static void main(String[] args) {

        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());



        get("/changeMachine", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ChangeMachine changeMachine = new ChangeMachine();
            Float cashInput = Float.parseFloat(request.queryParams("cashInput"));
            String change = changeMachine.makeChange(cashInput);
            model.put("change", change);
            return new ModelAndView(model, "coinoutput.hbs");
        }, new HandlebarsTemplateEngine());
    }
}


