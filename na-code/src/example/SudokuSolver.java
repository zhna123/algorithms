package example;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * Empty cells are indicated by the character '.'.
 * 
 * You may assume that there will be only one unique solution.
 * 
 */

public class SudokuSolver {
    public void solveSudoku(final char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return;
        }
        helper(board, 0, 0);
    }

    // main logic
    private boolean helper(final char[][] board, final int i, final int j) {

        // current row ends; go to next row
        if (j >= 9) {
            return helper(board, i + 1, 0);
        }

        // all the rows are checked, return
        if (i == 9) {
            return true;
        }

        // come to the cell that needs to fill in a number
        if (board[i][j] == '.') {
            // check all numbers to see which number is fit in
            for (int k = 1; k <= 9; k++) {
                board[i][j] = (char) (k + '0');
                if (isValid(board, i, j)) {
                    // check next
                    if (helper(board, i, j + 1)) {
                        return true;
                    }
                }
                // DFS (have to reset the cell after the dfs)
                board[i][j] = '.';
            }
        }
        else {
            // if the column is already filled,
            return helper(board, i, j + 1);
        }
        return false;
    }

    // i and j are current location
    // this is the method to check valid sudoku
    private boolean isValid(final char[][] board, final int i, final int j) {
        // see if current location conflicts with any cell in row i
        for (int k = 0; k < 9; k++) {
            if (k != j && board[i][k] == board[i][j]) {
                return false;
            }
        }

        // see if current location conflicts with any cell in column j
        for (int k = 0; k < 9; k++) {
            if (k != i && board[k][j] == board[i][j]) {
                return false;
            }
        }

        // check the 3X3 block which the current location is in
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) {
                if ((row != i || col != j) && board[row][col] == board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
