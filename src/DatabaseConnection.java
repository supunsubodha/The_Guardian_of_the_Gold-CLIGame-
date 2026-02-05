import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
            // use the connection to avoid 'variable never used' warning and validate connectivity
            if (connection.isValid(2)) {
                System.out.println("Success! Database is connected.");
            }
        } catch (SQLException e){
            System.out.println("Connection failed! Will try to create database and tables if possible.");
            createDatabase();//If connection failed it could be the first time this pc running the game,So first of all database and table should create.
            // try connecting again after creation
            try (Connection retry = DriverManager.getConnection(url, user, password)) {
                if (retry.isValid(2)) {
                    System.out.println("Success! Database is connected after creation.");
                }
            } catch (SQLException ex) {
                System.out.println("Connection failed after attempting to create database.");
            }
        }
    }
    public static void createDatabase(){
        System.out.println("Creating database...");
        // Connect to server without specifying the database so we can create it
        String serverUrl = "jdbc:mysql://localhost:3306/";
        try (Connection conn = DriverManager.getConnection(serverUrl,user,password);
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
            stmt.executeUpdate("INSERT INTO users(username,score,level) VALUES ('default',0,1)");
            System.out.println("Created default user successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void createUser(String username, int score, int level){
        String sql = "INSERT INTO users(username, score, level) VALUES (?, ?, ?)" +
                     " ON DUPLICATE KEY UPDATE score = VALUES(score), level = VALUES(level)";
        try (Connection conn = DriverManager.getConnection(url,user,password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setInt(2, score);
            pstmt.setInt(3, level);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Loading data from database
    public static int[] loadUserData(String username){
        int score = 0; // default
        int level = 1; // default
        String sql = "SELECT score, level FROM users WHERE username = ?";

        try (Connection conn = DriverManager.getConnection(url,user,password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    score = rs.getInt("score");
                    level = rs.getInt("level");
                }
            }

            return new int[]{score, level};

        } catch (SQLException e) {
            e.printStackTrace();
            return new int[]{score, level};
        }
    }
    public static void sqlExecuter(String sql) {
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

