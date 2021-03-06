package example;

/**
 * DP O(n^2)
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
 * corner of the grid (marked 'Finish' in the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * path[i][j] identifies the number of ways to reach (i, j)
 */
public class UniquePath {

    public int uniquePaths(final int m, final int n) {

        if (m == 0 || n == 0) {
            return 0;
        }

        final int path[][] = new int[m][n];

        // only 1 row
        for (int i = 0; i < n; i++) {
            path[0][i] = 1;
        }

        // only 1 column
        for (int j = 0; j < m; j++) {
            path[j][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // two ways to reach the goal: from left and from up
                path[i][j] = path[i - 1][j] + path[i][j - 1];
            }
        }

        return path[m - 1][n - 1];

    }

}
