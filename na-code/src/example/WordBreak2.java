package example;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid
 * dictionary word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 * 
 */
public class WordBreak2 {

    // brute force recursion
    public List<String> wordBreak(final String s, final Set<String> wordDict) {

        final List<String> res = new ArrayList<String>();
        if (s == null || s.isEmpty()) {
            return res;
        }
        helper(s, wordDict, 0, "", res);
        return res;
    }

    /**
     * 
     * @param s
     *            the string
     * @param wordDict
     *            the dictionary
     * @param loc
     * @param currentStr
     * @param res
     */
    private void helper(final String s, final Set<String> wordDict, final int loc, final String currentStr, final List<String> res) {

        if (loc == s.length()) {
            res.add(currentStr);
            return;
        }

        final StringBuilder str = new StringBuilder();
        // loop and a recursive to get all possible results
        for (int i = loc; i < s.length(); i++) {
            str.append(s.charAt(i));
            // save a current result, then recursively handle the rest of the string
            if (wordDict.contains(str.toString())) {
                final String newString = currentStr.length() > 0 ? (currentStr + " " + str.toString()) : str.toString();
                helper(s, wordDict, i + 1, newString, res);
            }
        }
    }
}
