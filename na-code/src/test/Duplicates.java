package test;

import java.util.HashMap;
import java.util.Map;

/**
 * remove duplicates from an array
 *
 * Errors corrected:
 * array.length
 * numberToCountMap.containsKey()
 *
 * multiple ways to remove duplicates
 * 1. map (as I did below)
 * 2. sort
 * 3. set (unique items only in set)
 * 4. create a boolean array to mark visited or not (need number range not too big)
 */
public class Duplicates {

    static int[] removeDuplicates(int[] unsorted) {
        Map<Integer, Integer> numberToCountMap = new HashMap();
        int length = unsorted.length;
        for (int i=0; i<length; i++) {
            if (!numberToCountMap.containsKey(unsorted[i])) {
                numberToCountMap.put(unsorted[i], 1);
            }
        }
        int[] results = new int[numberToCountMap.size()];
        int tmp = 0;
        for (Integer i : numberToCountMap.keySet()) {
            results[tmp] = i;
            tmp++;
        }
        return results;
    }

    public static void main(String[] args) {
        int[] test = new int[] {1, 5, 5, 7, 8, 3, 5, 7, 2, 1, 3};
        int[] result = removeDuplicates(test);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}
