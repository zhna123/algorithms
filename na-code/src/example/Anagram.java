package example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Anagram {

    public List<String> anagrams(final String[] strs) {

        final Map<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();

        // sort each string, and store in a map
        for (int i = 0; i < strs.length; i++) {
            final String str = strs[i];
            if (str.isEmpty()) {
                continue;
            }
            final char[] c = str.toCharArray();
            Arrays.sort(c);
            final String sorted = String.valueOf(c);

            if (map.containsKey(sorted)) {
                map.get(sorted).add(str);
            } else {
                final LinkedList<String> linkedList = new LinkedList<String>();
                linkedList.add(str);
                map.put(sorted, linkedList);
            }
        }

        final List<String> list = new LinkedList<String>();
        for (final LinkedList<String> strings : map.values()) {
            list.addAll(strings);
        }

        return list;
    }

    public static void main(final String[] args) {
        final Anagram an = new Anagram();
        final String[] strs = { "cat", "dog", "cta", "act", "god", "hello", "olleh" };
        System.out.println(an.anagrams(strs));
        final String[] strs1 = { "", "", "" };
        System.out.println(an.anagrams(strs1));
        final String[] strs2 = { "a" };
        System.out.println(an.anagrams(strs2));

    }
}
