package design.exercise4.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * 4-12. [3] Devise an algorithm for finding the k smallest elements of an unsorted set of n
 * integers in O(n + k log n).
 * 
 * @author nz026920
 * 
 */
public class EXE12 {

    // build min heap from array
    private static void heapify(final Comparable[] array, final int n, final int i) {
        int root = i;
        final int left = i * 2;
        final int right = i * 2 + 1;

        if (left < n && array[left].compareTo(array[root]) < 0) {
            root = left;
        }
        if (right < n && array[right].compareTo(array[root]) < 0) {
            root = right;
        }
        if (root != i) {
            // swap
            swap(array, i, root);
            heapify(array, n, root);
        }
    }

    private static void swap(final Comparable[] array, final int a, final int b) {
        final Comparable tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static List extract(final Comparable[] array, final int k) {
        final int n = array.length - 1;
        // build heap; start from top
        for (int i = n / 2; i >= 0; i--) {
            heapify(array, n, i);
        }
        final List results = new ArrayList(k);
        for (int i = n; i > 0; i--) {
            results.add(array[0]);
            if (results.size() == k) {
                break;
            }
            swap(array, 0, i);
            heapify(array, n, 0);

        }
        return results;
    }

    public static void main(final String[] args) {
        final Integer[] array = new Integer[] { 3, 4, 9, 1, 2, 7, 4, 5, 1 };
        final List results = extract(array, 4);
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }

}
