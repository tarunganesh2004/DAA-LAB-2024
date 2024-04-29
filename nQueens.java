import java.util.Scanner;

public class nQueens {
    private static boolean isSafe(int[][] board, int row, int col) {
        // Check if there is a queen in the same column up to the current row
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // Check upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check upper right diagonal
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private static boolean solveNQueens(int[][] board, int row) {
        int n = board.length;
        if (row == n) {
            return true;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;
                if (solveNQueens(board, row + 1)) {
                    return true;
                }
                board[row][col] = 0; // backtrack
            }
        }

        return false;
    }

    private static void printSolution(int[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the board (n x n): ");
        int n = scanner.nextInt();
        int[][] board = new int[n][n];

        if (solveNQueens(board, 0)) {
            System.out.println("Solution:");
            printSolution(board);
        } else {
            System.out.println("No solution exists");
        }
    }
}
