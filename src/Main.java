//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons . Actions . Execute"/> icon in the gutter . 
public class Main {
    public static void main(String[] args) {
        System . out . println("Welcome to the treasure hunt game!");
        System . out . println("Moves: U (up) , D (down) , L (Left) , R (Right)");

        String [][] board = {
                {" . "," . "," . "," . "," . "," . "," . "," . "," . "," . "},
                {" . "," . "," . "," . "," . "," . "," . "," . "," . "," . "},
                {" . "," . "," . "," . "," . "," . "," . "," . "," . "," . "},
                {" . "," . "," . "," . "," . "," . "," . "," . "," . "," . "},
                {" . "," . "," . "," . "," . "," . "," . "," . "," . "," . "},
                {" . "," . "," . "," . "," . "," . "," . "," . "," . "," . "},
                {" . "," . "," . "," . "," . "," . "," . "," . "," . "," . "},
                {" . "," . "," . "," . "," . "," . "," . "," . "," . "," . "},
                {" . "," . "," . "," . "," . "," . "," . "," . "," . "," . "},
                {" . "," . "," . "," . "," . "," . "," . "," . "," . "," . "}
        };
        for(String[] i:board){
            for(String j:i){
                System . out . print(j);
            }
            System . out . println();
        }
    }
}