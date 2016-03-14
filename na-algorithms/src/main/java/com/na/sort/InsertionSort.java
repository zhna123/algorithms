package main.java.com.na.sort;

import main.java.com.na.sort.helper.SortHelper;

public class InsertionSort {

    public int[] sort(final int[] items) {

        final int length = items.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j > 0 && items[j] < items[j - 1]; j--) {
                SortHelper.exchange(items, j, j - 1);
            }
        }
        return items;
    }
}
