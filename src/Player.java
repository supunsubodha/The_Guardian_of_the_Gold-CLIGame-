import java.util.Scanner;

public class Player {
    String username;
    int score;
    int level;
    int row;
    int col;

    Player (String name,int score,int level,int rowCordinate, int colordinate){
        this.username = name;
        this.score = score;
        this.level = level;
        this.row = rowCordinate;
        this.col = colordinate;

    }
    public boolean move(){
        Scanner sc = new Scanner(System.in);
        Main.displayBoard();
        System.out.println("Moves: W (up) , S (down) , A (Left) , D (Right)");
        System.out.print("Enter direction: ");
        char direction = sc.next().toLowerCase().charAt(0);
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
        if (verifyMovement(row,col)){//reversing player movement if movement is wrong
            System.out.println("Invalid move");
            switch (direction){
                case 'w':
                    row++;
                    move();
                    break;
                case 's':
                    row--;
                    move();
                    break;
                case 'a':
                    col++;
                    move();
                    break;
                case 'd':
                    col--;
                    move();
                    break;
                default:
                    System.out.println("Something went wrong");
            }
            Main.board [row][col] = " P ";//undo player movement
            move();

        }
        Main.board [row][col] = " P ";
        return true;
    }
    public boolean verifyMovement(int row,int col){
        if((row<0 || col<0) || (row>9 || col>9)){
            return true;
        }else{
            return false;
        }
    }
}

