package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by nz026920 on 8/15/16.
 */
public class Permutation {

    static Set<String> permutations(String str) {

        Set<String> result = new HashSet<String>();

        if (str.length() == 0) {
            result.add("");  // important base case
            return result;
        }

        String first = String.valueOf(str.charAt(0));
        String rest = str.substring(1);

        Set<String> permutations = permutations(rest);

        for (String s : permutations) {
            for (int i=0; i <= s.length(); i++) {
                String per = s.substring(0, i) + first + s.substring(i);
                result.add(per);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        String test = "abc";
        System.out.println(permutations(test));
    }


}
