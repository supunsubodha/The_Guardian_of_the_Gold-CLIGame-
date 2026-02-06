import java.util.Locale;
import java.util.Scanner;
public class Main {
    static String username;
    static int score;
    static int level;
    static String [][]board;
    static int rowStart;
    static int colStart;
    public static void main(String[] args) {

        // initialize board BEFORE selecting map to avoid NullPointerException in Maps
        board = new String[][]{
                {" . ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . "},
                {" . ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . "},
                {" . ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . "},
                {" . ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . "},
                {" . ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . "},
                {" . ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . "},
                {" . ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . "},
                {" . ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . "},
                {" . ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . "},
                {" . ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . "}
        };

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the treasure hunt game!");

        //Taking MYSQL username and password
        System.out.print("Please enter your MYSQL database username: ");
        String myUsername = sc.nextLine();
        System.out.print("Please enter your MYSQL database password: ");
        String myPassword = sc.nextLine();
        //Connecting MYSQL database
        DatabaseConnection.databaseConnection(myUsername, myPassword);

        //Create user or select user
        System.out.print("Enter (d) for use default user or enter (s) for create/select new user:  ");
        char userPreference = sc.next().toLowerCase().charAt(0);
        if (userPreference == 'd'){
            username = "default";
            int [] userdata = DatabaseConnection.loadUserData(username);//Call and load userdata
            score = userdata[0];
            level = userdata[1];
        }else if (userPreference == 's'){
            System.out.print("Enter (e) to continue with existing user or (c) for create new user:");
            char userPreference2 = sc.next().toLowerCase().charAt(0);
            if (userPreference2 == 'e'){
                System.out.print("Enter username: ");
                username = sc.next().toLowerCase();
                int [] userdata = DatabaseConnection.loadUserData(username);//Call and load userdata
                score = userdata[0];
                level = userdata[1];
            }else if (userPreference2 == 'c'){
                System.out.print("Enter username: ");
                username = sc.next().toLowerCase();
                score = 0;
                level = 0;
                // Quote the username so SQL treats it as a string literal.
                String sql = "INSERT INTO users (username,score,level) VALUES ('" + username + "'," + score + "," + level + ")";
                DatabaseConnection.sqlExecuter(sql);
            }else{
                System.out.println("invalid input");
                Main main;
            }
        }else{
            System.out.println("invalid input");
            Main main;
        }

        Maps mp  = new Maps();
        if(level == 0){
            newUserInstructions();
            level = 1;
            DatabaseConnection.sqlExecuter("UPDATE users SET level = 1 WHERE username = '" + username + "'");
        }

        System.out.println("Your are in the Level: " + level);
        mp.mapSelecter(level);//This will update the map

        Player player = new Player(username,score,level,rowStart,colStart);//Starting player
        while(player.move()){
            //until player.move return false this loop will continuously call the player.move()
        }

    }
    //This method is for display the board
    public static void displayBoard(){
        for(String[] i:board){
            for(String j:i){
                System . out . print(j);
            }
            System . out . println();
        }
    }
    public static void newUserInstructions(){
        Scanner sc = new Scanner(System.in);
        System.out.println("These instructions will be displayed only for new users. (Press Enter to continue)");
        sc.nextLine();

        System.out.println("In this game, you are a special government agent working to protect an ancient treasure that is about to be stolen by a thief named 'Magnus'.");
        sc.nextLine();

        System.out.println("Your job is to reach the treasure before Magnus and protect it.");
        sc.nextLine();

        System.out.println("The current situation is good for you because Magnus doesn't know the location of the treasure, but you know it very well.");
        sc.nextLine();

        System.out.println("Therefore, Magnus will search for the treasure everywhere on the map.");
        sc.nextLine();

        System.out.println("Take advantage of this and reach the treasure before Magnus does.");
        sc.nextLine();

        System.out.println("However, if you enter the same block where Magnus is, he will follow you and find the treasure.");
        sc.nextLine();

        System.out.println("So, avoid the blocks where Magnus is located.");
        sc.nextLine();

        System.out.println("Another important thing is to avoid traps denoted by 'x'.");
        sc.nextLine();

        System.out.println("I hope that you will protect the treasure from Magnus.");
        sc.nextLine();

        System.out.println("Good luck.");
        sc.nextLine();
    }
}