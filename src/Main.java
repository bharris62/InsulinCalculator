import jodd.json.JsonParser;
import jodd.json.JsonSerializer;
import org.h2.tools.Server;
import spark.Spark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {
        Model m = new Model();
        Server.createWebServer().start();
        Connection conn = DriverManager.getConnection("jdbc:h2:./main");
        m.createTables(conn);
        Spark.externalStaticFileLocation("public");
        Spark.init();

        Spark.get("/get-meals", (request, response) -> {
            ArrayList<Meal> messages = m.selectMeals(conn);
            JsonSerializer s = new JsonSerializer();
            return s.serialize(messages);
        });

        Spark.post("/post-meal", (request, response) -> {
            String body = request.body();
            JsonParser p = new JsonParser();
            Meal meal = p.parse(body, Meal.class);
            m.insertIntoMeals(conn, meal.getInsulinRatio(), meal.getCarb(), meal.getProtein(), meal.getFat(), meal.getCorrectionFactor());
            System.out.println("POSTED!");
            return "";
        });
    }

}
