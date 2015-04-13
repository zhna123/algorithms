package example;

/**
 * 
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * 
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * 
 * Note: m and n will be at most 100.
 * 
 * path[i][j] identifies the number of ways to reach (i, j)
 * 
 */
public class UniquePath2 {

    public int uniquePathsWithObstacles(final int[][] obstacleGrid) {
        final int m = obstacleGrid.length;
        final int n = obstacleGrid[0].length;

        if (m == 0 || n == 0) {
            return 0;
        }

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        final int[][] path = new int[m][n];

        path[0][0] = 1;

        // only 1 row
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                path[0][i] = 0;
            } else {
                // the path after i can't be used anymore
                path[0][i] = path[0][i - 1];
            }
        }

        // only 1 column
        for (int j = 1; j < m; j++) {
            if (obstacleGrid[j][0] == 1) {
                path[j][0] = 0;
            } else {
                // the path after j can't be used anymore
                path[j][0] = path[j - 1][0];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    path[i][j] = 0;
                } else {
                    path[i][j] = path[i - 1][j] + path[i][j - 1];
                }
            }
        }

        return path[m - 1][n - 1];
    }

}
