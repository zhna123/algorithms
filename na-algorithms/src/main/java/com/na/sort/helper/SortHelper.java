package main.java.com.na.sort.helper;

public class SortHelper {

    public static void exchange(final int[] items, final int a, final int b) {
        final int tmp = items[a];
        items[a] = items[b];
        items[b] = tmp;
    }

    public static boolean isSorted(final int[] items) {
        for (int i = 0; i < items.length - 1; i++) {
            if (items[i + 1] < items[i]) {
                return false;
            }
        }
        return true;
    }

}
