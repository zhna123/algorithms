package example;

import java.util.ArrayList;
import java.util.List;

/**
 * classic solution (loop and recursion)
 * 
 */
public class NQueens {

    public List<String[]> solveNQueens(final int n) {

        final List<String[]> res = new ArrayList<String[]>();
        final int[] columnForRow = new int[n];
        helper(n, 0, columnForRow, res);
        return res;
    }

    /**
     * 
     * @param n
     *            the number of rows/columns given
     * @param row
     *            the current row
     * @param columnForRow
     *            store the column queen i is at(this array made sure one queen exist in one row, so it only occupy one
     *            column)
     * @param res
     */
    private void helper(final int n, final int row, final int[] columnForRow, final List<String[]> res) {

        if (row == n) {
            // store one solution
            final String[] item = new String[n];
            for (int i = 0; i < n; i++) {
                final StringBuilder strRow = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    // mark the correct column
                    if (columnForRow[i] == j) {
                        strRow.append('Q');
                    } else {
                        strRow.append('.');
                    }
                }
                item[i] = strRow.toString();
            }
            // add one solution
            res.add(item);
        }

        // big loop to get all possible ways
        for (int i = 0; i < n; i++) {
            // checking all possible columns for each given row
            columnForRow[row] = i;
            if (check(row, columnForRow)) {
                helper(n, row + 1, columnForRow, res);
            }
        }

    }

    private boolean check(final int row, final int[] columnForRow) {
        // have to check if the new placed queen is in correct spot
        for (int i = 0; i < row; i++) {
            // check if the current column choose is in the same column with the previous queens
            if (columnForRow[row] == columnForRow[i] ||
                    // check diagonal
                    Math.abs(columnForRow[row] - columnForRow[i]) == row - i) {
                return false;
            }
        }
        return true;
    }
}
