package example;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to
 * end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
public class WordLadder {

    // bfs for shotest distance
    public int ladderLength(final String start, final String end, final HashSet<String> dict) {

        if (start == null || start.isEmpty() || end == null || end.isEmpty() || dict == null || dict.isEmpty()) {
            return 0;
        }

        final Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        dict.remove(start);
        int length = 1;
        while (!queue.isEmpty()) {
            final int count = queue.size();
            // check 1 level
            for (int i = 0; i < count; i++) {
                final String current = queue.poll();
                // check 1 word
                for (int j = 0; j < current.length(); j++) {
                    // check 1 letter
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == current.charAt(j)) {
                            continue;
                        }
                        final char[] ch = current.toCharArray();
                        ch[j] = k;
                        final String tmp = new String(ch);
                        // found end;
                        if (tmp.equals(end)) {
                            return length + 1;
                        }
                        if (dict.contains(tmp)) {
                            queue.add(tmp);
                            // it will result in infinity loop if not being removed
                            // actually, dict is like a visited mark; removed means visited, or not exist
                            dict.remove(tmp);
                        }
                    }// 1 letter
                }// 1 word
            }// this loop takes care of 1 level; (all the adjacent strings)
             // path length + 1 now
            length++;
        }

        return 0;
    }
}
