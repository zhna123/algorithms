package example;

import java.util.Set;

/**
 * 
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of
 * one or more dictionary words.
 * 
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * DP solution
 * use array seg[i] to indicate whether the string s[0, i-1] can be segmented
 * the following expression concludes all the situations:
 * seg[i] = true if seg[j] == true && s[j,i] exists in dict， 0<=j<i
 * 
 */

public class WordBreak {

    // prefered DP approach
    public boolean wordBreak(final String s, final Set<String> wordDict) {

        if (s == null || wordDict.size() <= 0) {
            return false;
        }

        final int length = s.length();
        final boolean[] seg = new boolean[length + 1];
        // initialize
        seg[0] = true;
        for (int i = 1; i <= length; i++) {
            // i>j>=0
            for (int j = 0; j < i; j++) {
                if (seg[j] && wordDict.contains(s.substring(j, i))) {
                    seg[i] = true;
                    continue;
                }

            }
        }

        return seg[length];
    }

    // recursion approach
    public boolean wordBreak1(final String s, final Set<String> dict) {
        // use a third parameter to keep track of the pointer location
        return wordBreakHelper(s, dict, 0);
    }

    private boolean wordBreakHelper(final String s, final Set<String> dict, final int start) {
        final int len = s.length();
        // reach the end of string s
        if (start == len) {
            return true;
        }

        // loop through all strings in dict
        for (final String a : dict) {
            final int end = start + a.length();

            // end index of the dict string should be <= string length in order to compare
            if (end > len) {
                continue;
            }

            if (s.substring(start, end).equals(a)) {
                if (wordBreakHelper(s, dict, end)) {
                    return true;
                }
            }
        }

        return false;
    }

}
