package main.java.com.na.sort;

import main.java.com.na.sort.helper.SortHelper;

/**
 * enhanced insertion sort; allow sorting elements far apart
 * 
 * @author nz026920
 * 
 */
public class ShellSort {

    public int[] sort(final int[] items) {

        final int length = items.length;

        // find the gap
        int h = 1;
        while (h < length / 3) {
            h = h * 3 + 1;
        }

        while (h >= 1) {
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h && items[j] < items[j - h]; j -= h) {
                    SortHelper.exchange(items, j, j - h);
                }
            }
            h /= 3;
        }
        return items;
    }

}
