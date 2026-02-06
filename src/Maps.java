public class Maps {
    public void mapSelecter(int level){
        switch (level){
            case 1:
                Main.rowStart = 0;
                Main.colStart = 0;
                level1();
                break;
            case 2:
                Main.rowStart = 1;
                Main.colStart = 1;
                level2();
                break;
            case 3:
                Main.rowStart = 0;
                Main.colStart = 0;
                level3();
                break;
            case 4:
                Main.rowStart = 9;
                Main.colStart = 0;
                level4();
                break;
            case 5:
                Main.rowStart = 0;
                Main.colStart = 0;
                level5();
                break;
            default:
                System.out.println("All levels are completed.");
        }
    }
    // Holds characters,traps and treasures according to leve
    public void level1(){
        Main.board [0][0] = " 👮🏽‍♂️";
        Main.board [0][6] = " 🥷🏽";
        Main.board [9][9] = "💰";
        Main.board [0][5] = Main.board [1][2] = Main.board [1][5] = Main.board [1][6] = Main.board [1][7] = Main.board [1][8] = Main.board [2][1] = Main.board [2][2] = Main.board [4][2] = Main.board [4][3] = Main.board [4][4] = Main.board [4][6] = Main.board [4][7] = Main.board [5][7] = Main.board [6][7] = Main.board [7][1] = Main.board [7][2] = Main.board [7][5] = Main.board [7][7] = Main.board [8][5] = Main.board [9][5] = " x ";
    }
    public void level2(){
        Main.board[1][1] = " 👮🏽‍♂️ ";
        Main.board[0][9] = " 🥷🏽 ";//Magnus
        Main.board[2][5] = "💰";
        Main.board[0][3] = Main.board[0][4] = Main.board[0][5] = Main.board[0][6] = Main.board[1][3] = Main.board[1][6] = Main.board[1][8] = Main.board[2][3] = Main.board[2][8] = Main.board[3][3] = Main.board[3][6] = Main.board[3][8] = Main.board[4][3] = Main.board[4][4] = Main.board[4][6] = Main.board[4][8] = Main.board[5][6] = Main.board[5][8] = Main.board[6][0] = Main.board[6][1] = Main.board[6][3] = Main.board[6][4] = Main.board[6][5] = Main.board[6][6] = Main.board[6][8] = Main.board[8][1] = Main.board[8][2] = Main.board[8][3] = Main.board[8][4] = Main.board[8][5] = Main.board[8][6] = Main.board[8][7] = Main.board[8][8] = " x ";
    }
    public void level3(){
        Main.board[0][0] = " 👮🏽‍♂️";
        Main.board[9][9] = " 🥷🏽";
        Main.board[6][4] = "💰";
        Main.board[0][2] = Main.board[1][0] = Main.board[1][2] = Main.board[1][4] = Main.board[1][5] = Main.board[1][6] = Main.board[1][7] = Main.board[1][8] = Main.board[2][8] = Main.board[3][1] = Main.board[3][2] = Main.board[3][3] = Main.board[3][4] = Main.board[3][6] = Main.board[3][8] = Main.board[4][1] = Main.board[4][6] = Main.board[5][1] = Main.board[5][3] = Main.board[5][4] = Main.board[5][5] = Main.board[5][6] = Main.board[5][8] = Main.board[6][3] = Main.board[6][5] = Main.board[6][8] = Main.board[7][1] = Main.board[7][3] = Main.board[7][5] = Main.board[7][7] = Main.board[7][8] = Main.board[9][7] = Main.board[9][8] = " x ";
    }
    public void level4(){
        Main.board[9][0] = " 👮🏽‍♂️";
        Main.board[0][0] = " 🥷🏽";
        Main.board[4][6] = "💰";
        Main.board[0][1] = Main.board[1][1] = Main.board[1][3] = Main.board[1][4] = Main.board[1][5] = Main.board[1][6] = Main.board[1][7] = Main.board[1][8] = Main.board[2][1] = Main.board[2][3] = Main.board[2][8] = Main.board[3][1] = Main.board[3][3] = Main.board[3][5] = Main.board[3][6] = Main.board[3][8] = Main.board[4][3] = Main.board[4][5] = Main.board[4][8] = Main.board[5][0] = Main.board[5][1] = Main.board[5][2] = Main.board[5][3] = Main.board[5][5] = Main.board[5][6] = Main.board[5][7] = Main.board[5][8] = Main.board[7][1] = Main.board[7][2] = Main.board[7][3] = Main.board[7][4] = Main.board[7][5] = Main.board[7][6] = Main.board[7][7] = Main.board[7][8] = Main.board[7][9] = " x ";
    }
    public void level5(){
        Main.board[0][0] = " 👮🏽‍♂️";
        Main.board[0][9] = " 🥷🏽";
        Main.board[5][4] = "💰";
        Main.board[0][2] = Main.board[0][7] = Main.board[1][2] = Main.board[1][4] = Main.board[1][5] = Main.board[1][7] = Main.board[2][0] = Main.board[2][9] = Main.board[3][1] = Main.board[3][2] = Main.board[3][3] = Main.board[3][6] = Main.board[3][7] = Main.board[3][8] = Main.board[4][3] = Main.board[4][6] = Main.board[5][1] = Main.board[5][3] = Main.board[5][6] = Main.board[5][8] = Main.board[6][1] = Main.board[6][3] = Main.board[6][4] = Main.board[6][5] = Main.board[6][6] = Main.board[6][8] = Main.board[8][0] = Main.board[8][1] = Main.board[8][2] = Main.board[8][4] = Main.board[8][5] = Main.board[8][7] = Main.board[8][8] = Main.board[8][9] = " x ";
    }


}
