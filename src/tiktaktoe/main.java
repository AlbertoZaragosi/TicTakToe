/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tiktaktoe;

/**
 *
 * @author neong
 */
import java.util.Scanner;
import java.util.Random;

public class main {

    private static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    private static char player = 'X';
    private static char ai = 'O';

    public static void main(String[] args) {
        displayBoard();
        while (true) {
            playerTurn();
            displayBoard();
            if (isWinner(player)) {
                System.out.println("Congratulations! You won!");
                break;
            }
            if (isTie()) {
                System.out.println("It's a tie!");
                break;
            }
            aiTurn();
            displayBoard();
            if (isWinner(ai)) {
                System.out.println("The AI won! Try again.");
                break;
            }
            if (isTie()) {
                System.out.println("It's a tie!");
                break;
            }
        }
    }

    private static void displayBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
        System.out.println();
    }

    private static void playerTurn() {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        do {
            System.out.println("Your turn, player " + player + ". Enter the row (0-2) and column (0-2) separated by a space:");
            row = scanner.nextInt();
            col = scanner.nextInt();
        } while (!isValidMove(row, col));
        board[row][col] = player;
    }

    private static void aiTurn() {
        Random rand = new Random();
        int row, col;
        do {
            row = rand.nextInt(3);
            col = rand.nextInt(3);
        } while (!isValidMove(row, col));
        System.out.println("The AI played in row " + row + " and column " + col);
        board[row][col] = ai;
    }

    private static boolean isValidMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ') {
            System.out.println("Invalid move. Try again.");
            return false;
        }
        return true;
    }

    private static boolean isWinner(char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        // Check diagonals
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    private static boolean isTie() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}

