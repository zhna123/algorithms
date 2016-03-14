package design.exercise3;

import java.util.Stack;

/**
 * 3-1
 * 1. check if a string contains properly matched parentheses
 * 2. identify the position of the first offending parenthesis
 * 
 * @author nz026920
 * 
 */
public class MatchParentheses {

    public boolean isParenthesesMatched(final String str) {

        if (str == null || str.length() == 0) {
            return true;
        }

        final Stack<Character> pStack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {

            final char ch = str.charAt(i);

            if (ch == '(') {
                pStack.push(ch);
                continue;
            }

            if (ch == ')' && !pStack.isEmpty()) {
                pStack.pop();

                if (i == str.length() - 1 && pStack.isEmpty()) {
                    return true;
                }
                continue;
            } else if (ch == ')' && pStack.isEmpty()) {
                System.out.println(i);
                return false;
            }
        }
        if (!pStack.isEmpty()) {
            System.out.println("not complete.");
        }
        return false;
    }

}
