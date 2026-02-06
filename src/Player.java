import java.util.Scanner;

public class Player {
    String username;
    int score;
    int level;
    int row;
    int col;

    Player (String name,int score,int level,int rowCordinate, int colCordinate){
        this.username = name;
        this.score = score;
        this.level = level;
        this.row = rowCordinate;
        this.col = colCordinate;

    }
    public boolean move(){
        Scanner sc = new Scanner(System.in);
        Main.displayBoard();
        System.out.println("Moves: W (up) , S (down) , A (Left) , D (Right)");
        System.out.print("Enter direction: ");
        char direction = sc.next().toLowerCase().charAt(0);

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

        if(Main.board[row][col].equals(" x ")){
            GameOver();
            return false;
        }
        Main.board [row][col] = " 👮🏽‍♂️";
        return true;
    }
    public boolean verifyMovement(int temprow,int tempcol){
        if((temprow<0 || tempcol<0) || (temprow>9 || tempcol>9)){
            return true;
        }else{
            return false;
        }
    }
    public void GameOver(){
        System.out.println("You walked into a trap.");
        System.out.println("Game Over, Try Again!");
    }
}

