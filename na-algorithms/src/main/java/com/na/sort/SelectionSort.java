package main.java.com.na.sort;

import main.java.com.na.sort.helper.SortHelper;

/**
 * Always select the minimum item, and switch
 * 
 * @author nz026920
 * 
 */
public class SelectionSort {

    public int[] sort(final int[] items) {

        final int length = items.length;

        for (int i = 0; i < length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {

                if (items[j] < items[min]) {
                    min = j;
                }
            }
            SortHelper.exchange(items, i, min);
        }

        return items;
    }

}
