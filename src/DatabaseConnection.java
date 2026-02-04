import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static void databaseConnection(String databaseUsername, String databasePassword) {
        String url = "jdbc:mysql://localhost:3306/game";
        String user = databaseUsername;
        String password = databasePassword;

        System.out.println("Connecting...");

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Success! Database is connected.");
        }catch (SQLException e){
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}
