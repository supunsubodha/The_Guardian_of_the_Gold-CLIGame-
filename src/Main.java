public class Main {
    static String [][]board;
    public static void main(String[] args) {
        System . out . println("Welcome to the treasure hunt game!");
        System . out . println("Moves: U (up) , D (down) , L (Left) , R (Right)");

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
    }
    public static void displayBoard(){
        for(String[] i:board){
            for(String j:i){
                System . out . print(j);
            }
            System . out . println();
        }
    }
}