package week1.unionfind;

/**
 * The idea of quick find is to check if array[a] == array[b].
 * if so, a and b are connected
 * So in order to union p and q, we need to change the value
 * of array[p] to be the value of array[q]
 * 
 * @author nz026920
 * 
 */
public class QuickFind {
    private final int n;
    private final int[] id;

    public QuickFind(final int n) {
        this.n = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public boolean connected(final int p, final int q) {
        return id[p] == id[q];
    }

    public void union(final int p, final int q) {
        final int pvalue = id[p];
        final int qvalue = id[q];
        for (int i = 0; i < n; i++) {
            if (i == pvalue) {
                id[i] = qvalue;
            }
        }
    }
}