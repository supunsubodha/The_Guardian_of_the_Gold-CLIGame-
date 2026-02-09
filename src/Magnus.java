public class Magnus {
    static int magnusRow;
    static int magnusCol;

    public static void magnusMovement (int level,int magnusMovement) {
        int[][] maglevel1 = {{0, 6}, {0, 7}, {0, 8}, {0, 9}, {1, 9}, {2, 9}, {2, 8}, {2, 7}, {2, 6}, {2, 5}, {3, 5}, {4, 5}, {5, 5}, {6, 5}, {6, 6}, {7, 6}, {8, 6}, {8, 7}, {8, 8}, {8, 9}, {9, 9}};
        int[][] maglevel2 = {{0,9},{0,8},{0,7},{1,7},{2,7},{3,7},{4,7},{5,7},{4,7},{3,7},{2,7},{2,6},{2,5}};
        int[][] maglevel3 = {{9,9},{8,9},{8,8},{7,9},{6,9},{5,9},{4,9},{4,8},{4,7},{5,7},{6,7},{6,6},{7,6},{8,6},{8,5},{8,4},{7,4},{6,4}};
        int[][] maglevel4 = {{9,9},{9,8},{9,7},{9,6},{8,6},{8,5},{9,5},{9,4},{9,3},{8,3},{8,2},{9,2},{9,1},{9,0},{8,0},{7,0},{6,0},{6,1},{6,2},{6,3},{6,4},{6,5},{6,6},{6,7},{6,8},{6,9},{6,8},{6,7},{6,6},{6,5},{6,4},{6,3},{6,4},{5,4},{4,4},{3,4},{2,4},{2,5},{2,6},{2,7},{3,7},{4,7},{4,6}};
        int[][] maglevel5 = {{9,9},{9,8},{9,7},{9,6},{8,6},{7,6},{7,7},{7,8},{7,9},{6,9},{6,8},{6,7},{5,7},{4,7},{4,8},{4,9},{3,9},{2,9},{2,8},{2,7},{1,7},{2,7},{2,6},{2,5},{3,5},{4,5},{5,5},{5,4}};


                switch (level) {
                    case 1:
                        magnusRow = maglevel1[magnusMovement][0];
                        magnusCol = maglevel1[magnusMovement][1];
                        if (magnusMovement != 0) {
                            Main.board[maglevel1[magnusMovement - 1][0]][maglevel1[magnusMovement - 1][1]] = " . ";
                        }
                        if (magnusRow == 9 && magnusCol == 9) {
                            Main.board[magnusRow][magnusCol] = " 🦹🏽";
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
                        magnusRow = maglevel3[magnusMovement][0];
                        magnusCol = maglevel3[magnusMovement][1];
                        if (magnusMovement != 0) {
                            Main.board[maglevel3[magnusMovement - 1][0]][maglevel3[magnusMovement - 1][1]] = " . ";
                        }
                        if (magnusRow == 6 && magnusCol == 4) {
                            Player.GameOver('m');
                        }
                        Main.board[magnusRow][magnusCol] = " 🦹🏽";
                        break;
                    case 4:
                        magnusRow = maglevel4[magnusMovement][0];
                        magnusCol = maglevel4[magnusMovement][1];
                        if (magnusMovement != 0) {
                            Main.board[maglevel4[magnusMovement - 1][0]][maglevel4[magnusMovement - 1][1]] = " . ";
                        }
                        if (magnusRow == 4 && magnusCol == 6) {
                            Player.GameOver('m');
                        }
                        Main.board[magnusRow][magnusCol] = " 🦹🏽";
                        break;
                    case 5:
                        magnusRow = maglevel5[magnusMovement][0];
                        magnusCol = maglevel5[magnusMovement][1];
                        if (magnusMovement != 0) {
                            Main.board[maglevel5[magnusMovement - 1][0]][maglevel5[magnusMovement - 1][1]] = " . ";
                        }
                        if (magnusRow == 5 && magnusCol == 4) {
                            Player.GameOver('m');
                        }
                        Main.board[magnusRow][magnusCol] = " 🦹🏽";
                        break;
                    default:
                        System.out.println("Invalid level");
                }
    }
}
