package test;

import java.util.Arrays;
import java.util.Collections;

/**
 * find pairs with sum 10 from array
 *
 * Arrays.sort() to sort array
 * for loop having multiple variables
 * for loop incrementing condition (can be omitted if needed to)
 * for loop indexing
 * pay attention of duplicates
 */
public class FindSum {

    // brutal force
    static void findSum(int[] array) {
        int length = array.length;
        for (int i=0; i<length; i++) {
            for (int j=i+1; j<length; j++) {
                if (array[i] +array[j] == 10) {
                    System.out.println("pair:" + array[i] + "and" + array[j]);
                }
            }
        }
    }

    // need to take care of duplicates
    static void findSum2(int[] array) {
        Arrays.sort(array);
        int length = array.length;
        int half = length/2;
        for (int i=0, j=length-1; i<half&&j>half; ) {   // be careful of this line
            if (array[i] + array[j] == 10) {
                System.out.println("pair:" + array[i] + "and" + array[j]);
                i++; j--;
            } else
            if (array[i] + array[j] > 10) {
                j--;
            } else
            if (array[i] +array[j] < 10) {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{2,5,1,4,6,8,9};
        findSum2(test);
    }

}
