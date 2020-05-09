package org.mikaela;

public class WinnnigCombinationCheck {
    static boolean checkDiagonalL(char[][] board, char letter) {
        if (board[0][0] == letter && board[1][1] == letter && board[2][2] == letter) {
            return true;
        }
//        for (int row = 0; row < 3; row++) {
//            int count = 0;
//            for (int column = 0; column < 3; column++) {
//                if (column == row && board[column][row] == letter) {
//                    count++;
//                    if (count == 3) {
//                        return true;
//                    }
//                }
//            }
//        }
        return false;
    }

    static boolean checkDiagonalR(char[][] board, char letter) {
        if (board[0][2] == letter && board[1][1] == letter && board[2][0] == letter) {
            return true;
        }
        return false;
    }

    static boolean checkRows(char[][] board, char letter) {
        for (int row = 0; row < 3; row++) {
            int count = 0;
            for (int column = 0; column < 3; column++) {
                if (board[column][row] == letter) {
                    count++;
                    if (count == 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static boolean checkColumns(char[][] board, char winningLetter) {
        for (int row = 0; row < 3; row++) {
            int count = 0;
            for (int column = 0; column < 3; column++) {
                if (board[row][column] == winningLetter) {
                    count++;
                    if (count == 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

