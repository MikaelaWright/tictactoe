package org.mikaela;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        String playerTurn = "p1";
        Scanner scanner = new Scanner(System.in);

        boolean gameOver = false;

        while (!gameOver) {
            Board.drawBoard(board);
            playerTurn = updateBoard(board, playerTurn, scanner);
            gameOver = detectEndgame(board);
        }

    }

    private static String updateBoard(char[][] board, String playerTurn, Scanner scanner) {
        System.out.println(playerTurn + "'s turn");
        System.out.println("Enter row: ");
        int userRow = scanner.nextInt();
        System.out.println("Enter column: ");
        int userColumn = scanner.nextInt();

        if (playerTurn.equals("p1")) {
            if (board[userRow][userColumn] == 0) {
                board[userRow][userColumn] = 'x';
                playerTurn = "p2";
            } else {
                System.out.println("Space already occupied. Try again");
                playerTurn = "p1";
            }
        } else {
            if (board[userRow][userColumn] == 0) {
                board[userRow][userColumn] = 'o';
                playerTurn = "p1";
            } else {
                System.out.println("Space already occupied. Try again");
                playerTurn = "p2";
            }
        }

        return playerTurn;
    }

    private static boolean detectEndgame(char[][] board) {

        if (checkPlayerWins(board, "p1 wins", 'x')) {
            Board.drawBoard(board);
            return true;
        }

        if (checkPlayerWins(board, "p2 wins", 'o')) {
            Board.drawBoard(board);
            return true;
        }

        if (checkBoardFull(board)) {
            Board.drawBoard(board);
            System.out.println("draw");
            return true;
        }
        return false;
    }

    private static boolean checkBoardFull(char[][] board) {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (board[column][row] != 'x' && board[column][row] != 'o') {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkPlayerWins(char[][] board, String label, char letter) {

        if (WinnnigCombinationCheck.checkColumns(board, letter)) {
            System.out.println(label);
            return true;
        }
        if (WinnnigCombinationCheck.checkRows(board, letter)) {
            System.out.println(label);
            return true;
        }
        if (WinnnigCombinationCheck.checkDiagonalL(board, letter)) {
            System.out.println(label);
            return true;
        }
        if (WinnnigCombinationCheck.checkDiagonalR(board, letter)) {
            System.out.println(label);
            return true;
        }
        return false;
    }
}
