package example;

import java.util.Stack;

// using floodfill algorithm. 
// 1. replace the boundaries "O" to "#"
// 2. using dfs or bfs replace all the connected Os on the boundaries
// 3. replace all the rest of the "O" to "X"
// 4. replace "#" back to "O"
public class SurroundedRegions {

    public void solve(final char[][] board) {

        // edge cases
        // if only 1 element, there is nothing we can do (pay attention to the order)
        if (board == null || board.length <= 1 || board[0].length <= 1) {
            return;
        }

        // replace upper and lower edges (O -> #)
        for (int i = 0; i < board[0].length; i++) {
            fill(board, 0, i);
            fill(board, board.length - 1, i);
        }

        // replace left and right edges (O -> #)
        for (int i = 0; i < board.length; i++) {
            fill(board, i, 0);
            fill(board, i, board[0].length - 1);
        }

        // now we cleared all the obstacles, we can start replacing all fields (O -> X; # -> O)
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    // recursive solution (will potentially cause stack over flow error)
    private void fill(final char[][] board, final int i, final int j) {

        // pay attention to how i and j are passed in to determine the conditions here
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] == 'O') {

            board[i][j] = '#';

            fill(board, i + 1, j);
            fill(board, i - 1, j);
            fill(board, i, j + 1);
            fill(board, i, j - 1);
        }

    }

    // using stack (accepted solution)
    private void fill2(final char[][] board, final int i, final int j) {

        if (board[i][j] == 'X') {
            return;
        }

        if (i >= board.length || j >= board[0].length) {
            return;
        }

        final Stack<Point> stack = new Stack<Point>();
        stack.push(new Point(i, j, board[i][j]));

        while (!stack.isEmpty()) {
            final Point p = stack.pop();
            board[p.getX()][p.getY()] = '#';

            if (p.getX() + 1 < board.length) {
                final Point p1 = new Point(p.getX() + 1, p.getY(), board[p.getX() + 1][p.getY()]);
                if (p1.getCh() == 'O') {
                    stack.push(p1);
                }
            }

            if (p.getX() - 1 >= 0) {
                final Point p2 = new Point(p.getX() - 1, p.getY(), board[p.getX() - 1][p.getY()]);
                if (p2.getCh() == 'O') {
                    stack.push(p2);
                }
            }

            if (p.getY() + 1 < board[0].length) {
                final Point p3 = new Point(p.getX(), p.getY() + 1, board[p.getX()][p.getY() + 1]);
                if (p3.getCh() == 'O') {
                    stack.push(p3);
                }
            }

            if (p.getY() - 1 >= 0) {
                final Point p4 = new Point(p.getX(), p.getY() - 1, board[p.getX()][p.getY() - 1]);
                if (p4.getCh() == 'O') {
                    stack.push(p4);
                }
            }
        }

    }

    class Point {

        private final int x;
        private final int y;
        private char ch;

        public Point(final int x, final int y, final char ch) {
            this.x = x;
            this.y = y;
            this.ch = ch;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public char getCh() {
            return this.ch;
        }

        public void setCh(final char ch) {
            this.ch = ch;
        }

    }
}
