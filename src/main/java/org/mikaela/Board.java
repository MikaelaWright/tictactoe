package org.mikaela;

public class Board {
    static void drawBoard(char[][] board) {
        for (int row = 0; row < 3; row++) {
            System.out.println("- - - -");
            for (int column = 0; column < 3; column++) {
                System.out.print(board[row][column]);
                System.out.print("  ");
            }
            System.out.print("\n");
        }
        System.out.println("- - - -");
    }

    static void emptyBoard(char[][] board) {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                board[row][column] = 0;
            }
        }

    }

}

