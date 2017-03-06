import java.sql.*;
import java.util.ArrayList;

public class Model {
    public void createTables(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.execute(
                "CREATE TABLE IF NOT EXISTS meals (id IDENTITY, " +
                                                        "insulin_ratio DOUBLE, " +
                                                        "carb DOUBLE, " +
                                                        "protein DOUBLE, " +
                                                        "fat DOUBLE, " +
                                                        "correction_factor DOUBLE);");
    }
    public void insertIntoMeals(Connection conn, double ir, double carb, double protein, double fat, double cf) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO meals VALUES (NULL, ?,?,?,?,?)");
        stmt.setDouble(1, ir);
        stmt.setDouble(2, carb);
        stmt.setDouble(3, protein);
        stmt.setDouble(4, fat);
        stmt.setDouble(5, cf);
        stmt.execute();
    }

    public Meal selectMeal(Connection conn, int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM meals WHERE id=?;");
        stmt.setInt(1, id);
        ResultSet result = stmt.executeQuery();
        if (result.next()) {
            double insulinRatio = result.getDouble("insulin_ratio");
            double carb = result.getDouble("carb");
            double protein = result.getDouble("protein");
            double fat = result.getDouble("fat");
            double cf = result.getDouble("correction_factor");

            return new Meal(id, insulinRatio, carb, protein, fat, cf);
        }

        return null;
    }

    public ArrayList<Meal> selectMeals(Connection conn) throws SQLException {
        ArrayList<Meal> meals = new ArrayList<>();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM meals;");
        ResultSet result = stmt.executeQuery();
        while(result.next()) {
            int id = result.getInt("id");
            double insulinRatio = result.getDouble("insulin_ratio");
            double carb = result.getDouble("carb");
            double protein = result.getDouble("protein");
            double fat = result.getDouble("fat");
            double cf = result.getDouble("correction_factor");

            meals.add(new Meal(id, insulinRatio, carb, protein, fat, cf));
        }

        return meals;
    }
}
