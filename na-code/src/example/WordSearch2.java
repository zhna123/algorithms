package example;

import java.util.Stack;

// non-recursive solution, used 2 stacks
public class WordSearch2 {

    public boolean exist(final char[][] board, final String word) {

        if (word == null) {
            return true;
        }

        if (board == null) {
            return false;
        }

        if (board.length * board[0].length < word.length()) {
            return false;
        }

        final int row = board.length;  // height
        final int col = board[0].length; // width

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (board[i][j] == word.charAt(0)) {
                    final boolean[][] visited = new boolean[row][col];
                    final Stack<Point> boardStack = new Stack<Point>();
                    final Stack<Integer> wordStack = new Stack<Integer>();

                    // push a root
                    boardStack.push(new Point(i, j, board[i][j]));
                    wordStack.push(0);

                    while (!boardStack.empty()) {
                        final Point p = boardStack.peek();
                        final int x = p.getX(); // current row position
                        final int y = p.getY(); // current col position
                        final int pos = wordStack.peek();

                        // if already visited(no unvisited child anymore), reset, and pop
                        if (visited[x][y]) {
                            visited[x][y] = false;
                            boardStack.pop();
                            wordStack.pop();
                            continue;
                        }

                        if (board[x][y] == word.charAt(pos)) {
                            visited[x][y] = true;
                            if (pos == word.length() - 1) {
                                return true;
                            }
                            // push unvisited child on to stack
                            if (x - 1 >= 0 && !visited[x - 1][y]) {
                                boardStack.push(new Point(x - 1, y, board[x - 1][y]));
                                wordStack.push(pos + 1);
                            }
                            if (x + 1 < row && !visited[x + 1][y]) {
                                boardStack.push(new Point(x + 1, y, board[x + 1][y]));
                                wordStack.push(pos + 1);
                            }
                            if (y - 1 >= 0 && !visited[x][y - 1]) {
                                boardStack.push(new Point(x, y - 1, board[x][y - 1]));
                                wordStack.push(pos + 1);
                            }
                            if (y + 1 < col && !visited[x][y + 1]) {
                                boardStack.push(new Point(x, y + 1, board[x][y + 1]));
                                wordStack.push(pos + 1);
                            }
                        } else {
                            boardStack.pop();
                            wordStack.pop();
                        }
                    }
                }
            }
        }
        return false;
    }

    class Point {

        private final int x;
        private final int y;
        private final char ch;

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

    }

    public static void main(final String[] args) {
        // "CAA","AAA","BCD"], "AAB
        final char[][] board = new char[][] { { 'c', 'a', 'a' },
                { 'a', 'a', 'a' },
                { 'b', 'c', 'd' } };
        final String word = "aab";
        final WordSearch ws = new WordSearch();
        if (ws.exist(board, word)) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }
    }

}
