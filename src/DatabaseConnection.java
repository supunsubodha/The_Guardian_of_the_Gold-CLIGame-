import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    static String url;
    static String user;
    static String password;
    public static void databaseConnection(String databaseUsername, String databasePassword) {
        url = "jdbc:mysql://localhost:3306/game";
        user = databaseUsername;
        password = databasePassword;

        System.out.println("Connecting...");

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Success! Database is connected.");
        }catch (SQLException e){
            System.out.println("Connection failed!");
            createDatabase();//If connection failed it could be the first time this pc running the game,So first of all database and table should create.
        }
    }
    public static void createDatabase(){
        System.out.println("Creating database...");
        try (Connection conn = DriverManager.getConnection(url,user,password);
             Statement stmt = conn.createStatement()) {

            // Create database
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS game");
            System.out.println("Database created successfully.");

            // Use the new database
            stmt.executeUpdate("USE game");

            // Create table(s)
            String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                    "username varchar(50) PRIMARY KEY," +
                    "score INT," +
                    "level INT);";
            stmt.executeUpdate(createTableSQL);
            System.out.println("Tables created successfully.");
            stmt.executeUpdate("INSERT INTO users(username,score,level) VALUES ('default',0,1);");
            System.out.println("Created default user successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
