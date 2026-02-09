import java.util.Objects;
import java.util.Scanner;

public class Player {
    String username;
    int score;
    int level;
    int row;
    int col;
    static int magnusMovement;
    static boolean status;

    Player (String name,int score,int level,int rowCordinate, int colCordinate){
        this.username = name;
        this.score = score;
        this.level = level;
        this.row = rowCordinate;
        this.col = colCordinate;

    }
    public boolean move(){
        SoundPlayer sp = new SoundPlayer();
        status = true;
        Scanner sc = new Scanner(System.in);
        Main.displayBoard();
        System.out.println("Moves: W (up) , S (down) , A (Left) , D (Right)");
        System.out.print("Enter direction: ");
        char direction = sc.next().toLowerCase().charAt(0);
        sp.playSounds('m');

        int temprow = row;
        int tempcol = col;

        switch (direction){//Checking movement before proceed
            case 'w':
                temprow--;
                break;
            case 's':
                temprow++;
                break;
            case 'a':
                tempcol--;
                break;
            case 'd':
                tempcol++;
                break;
            default:
                System.out.println("Invalid direction");
        }

        if(verifyMovement(temprow,tempcol)){
            System.out.println("Invalid movement.Don't try to step out from scope.");
            return true;
        }

        switch (direction){//Making player movement
            case 'w':
                Main.board [row][col] = " . ";
                row--;
                break;
            case 's':
                Main.board [row][col] = " . ";
                row++;
                break;
            case 'a':
                Main.board [row][col] = " . ";
                col--;
                break;
            case 'd':
                Main.board [row][col] = " . ";
                col++;
                break;
            default:
                System.out.println("Invalid direction");
            move();
        }

        if(Main.board[row][col].equals(" x ")){//Compare player's position with bombs and Magnus's positions
            GameOver('x');
            return false;
        }
        if (row == Magnus.magnusRow && col == Magnus.magnusCol) {
            GameOver('d');
        }
        if(Main.board[row][col].equals("💰")){
            levelCompleted();
        }

        Main.board [row][col] = " 👮🏽‍♂️";
        magnusMovement++;
        Magnus.magnusMovement(level,magnusMovement);
        return status;
    }

    public boolean verifyMovement(int temprow,int tempcol){//This function help to keep user inside the scope
        if((temprow<0 || tempcol<0) || (temprow>9 || tempcol>9)){
            return true;
        }else{
            return false;
        }
    }
    public static void GameOver(char reason){
        Scanner sc = new Scanner(System.in);
        switch (reason){
            case 'm':
                System.out.println(Colors.RED+"Magnus discovered the treasure.🦹🏽💰😔"+Colors.RESET);
                break;
            case 'x':
                System.out.println(Colors.RED+"You walked into a trap.💣😔"+Colors.RESET);
                break;
            case 'd':
                System.out.println(Colors.RED+"Magnus found you. He will be follow you secretly.😨"+Colors.RESET);
                break;
            default:
                System.out.println("Invalid reason");
        }
        SoundPlayer sp = new SoundPlayer();
        sp.playSounds('o');
        System.out.println(Colors.RED+"Game Over, Try Again!"+Colors.RESET);
        System.out.println("Press enter to continue...");
        sc.nextLine();
        Main.resetGame();
        Main.nextLevel();
    }
    public void levelCompleted(){
        Scanner sc = new Scanner(System.in);
        SoundPlayer sp = new SoundPlayer();
        System.out.println(Colors.GREEN+"Congratulations!🎉 You got the level complete."+Colors.RESET);
        String sql = "UPDATE users SET level = " + (level + 1) + " WHERE username = '" + username + "'";
        DatabaseConnection.sqlExecuter(sql);
        sp.playSounds('l');
        Main.resetGame();
        System.out.print("Press Enter to continue to the next level.");
        sc.nextLine();
        Main.nextLevel();
    }
}
