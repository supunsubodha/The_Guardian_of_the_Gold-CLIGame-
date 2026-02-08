public class Magnus {
    static int magnusRow;
    static int magnusCol;

    public static void magnusMovement (int level,int magnusMovement) {
        int[][] maglevel1 = {{0, 6}, {0, 7}, {0, 8}, {0, 9}, {1, 9}, {2, 9}, {2, 8}, {2, 7}, {2, 6}, {2, 5}, {3, 5}, {4, 5}, {5, 5}, {6, 5}, {6, 6}, {7, 6}, {8, 6}, {8, 7}, {8, 8}, {8, 9}, {9, 9}};
        int[][] maglevel2 = {{0,9},{0,8},{0,7},{1,7},{2,7},{3,7},{4,7},{5,7},{4,7},{3,7},{2,7},{2,6},{2,5}};


                switch (level) {
                    case 1:
                        magnusRow = maglevel1[magnusMovement][0];
                        magnusCol = maglevel1[magnusMovement][1];
                        if (magnusMovement != 0) {
                            Main.board[maglevel1[magnusMovement - 1][0]][maglevel1[magnusMovement - 1][1]] = " . ";
                        }
                        if (magnusRow == 9 && magnusCol == 9) {
                            Player.GameOver('m');
                        }
                        Main.board[magnusRow][magnusCol] = " 🦹🏽";
                        break;
                    case 2:
                        magnusRow = maglevel2[magnusMovement][0];
                        magnusCol = maglevel2[magnusMovement][1];
                        if (magnusMovement != 0) {
                            Main.board[maglevel2[magnusMovement - 1][0]][maglevel2[magnusMovement - 1][1]] = " . ";
                        }
                        if (magnusRow == 2 && magnusCol == 5) {
                            Player.GameOver('m');
                        }
                        Main.board[magnusRow][magnusCol] = " 🦹🏽";
                        break;
                    case 3:
                        magnusRow = maglevel1[magnusMovement][0];
                        magnusCol = maglevel1[magnusMovement][1];
                        break;
                    case 4:
                        magnusRow = maglevel1[magnusMovement][0];
                        magnusCol = maglevel1[magnusMovement][1];
                        break;
                    case 5:
                        magnusRow = maglevel1[magnusMovement][0];
                        magnusCol = maglevel1[magnusMovement][1];
                        break;
                    default:
                        System.out.println("Invalid level");
                }
    }
}
