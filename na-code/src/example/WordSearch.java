package example;

// back tracking 
public class WordSearch {

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

        final char ch = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == ch) {
                    // recursive method
                    if (search(board, word.substring(1), i, j)) {
                        return true;
                    }
                }

            }
        }

        return false;

    }

    // recursive dfs
    private boolean search(final char[][] board, final String word, final int i, final int j) {
        // done matching
        if (word.isEmpty()) {
            return true;
        }
        final char ch = word.charAt(0);
        final char tmp = board[i][j];
        board[i][j] = ' ';
        // down
        if (i + 1 < board.length && board[i + 1][j] == ch) {
            if (search(board, word.substring(1), i + 1, j)) {
                return true;
            }
        }
        // up
        if (i - 1 >= 0 && board[i - 1][j] == ch) {
            if (search(board, word.substring(1), i - 1, j)) {
                return true;
            }
        }
        // right
        if (j + 1 < board[0].length && board[i][j + 1] == ch) {
            if (search(board, word.substring(1), i, j + 1)) {
                return true;
            }
        }
        // left
        if (j - 1 >= 0 && board[i][j - 1] == ch) {
            if (search(board, word.substring(1), i, j - 1)) {
                return true;
            }
        }
        board[i][j] = tmp;
        return false;
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
