package test;

import java.util.HashMap;
import java.util.Map;

/**
 * find most frequent integer from an array
 *
 *
 * no syntax error;
 *
 * need to think about what if there are multiple integers qualify(print all? print first?)
 * if print all, we can get the value only first, then try to find all the keys by looping through the map and compare the value
 */
public class MostFrequentInteger {

    // find the first
    static int findMostFrequentInt(int[] array) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) +1);
            } else {
                map.put(array[i], 1);
            }
        }
        int sum=0;
        int largest = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int newSum = entry.getValue();
            if (newSum > sum) {
                sum = newSum;
                largest = entry.getKey();
            }
        }
        return largest;
    }

    public static void main(String[] arags) {
        int[] testArray = new int[] {2,2,5,6,3,3,5,7,9,6,6,2,4,5,6,6,6,7};
        int result = findMostFrequentInt(testArray);
        System.out.println(result);
    }

}
