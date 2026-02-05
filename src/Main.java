import java.util.Locale;
import java.util.Scanner;
public class Main {
    static String username;
    static int score;
    static int level;
    static String [][]board;
    public static void main(String[] args) {
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
                DatabaseConnection.createUser(username,score,level);
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

        mp.mapSelecter(level);//This will update the map

        System.out.println("Moves: U (up) , D (down) , L (Left) , R (Right)");

        displayBoard();
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

    }
}