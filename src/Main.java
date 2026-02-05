import java.util.Scanner;
public class Main {
    static String [][]board;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the treasure hunt game!");
        System.out.print("Enter your username: ");
        String username = sc.nextLine();
        System.out.println("Moves: U (up) , D (down) , L (Left) , R (Right)");

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

        displayBoard();
        DatabaseConnection.databaseConnection("subodha","");
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
}