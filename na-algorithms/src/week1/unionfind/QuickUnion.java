package week1.unionfind;

/**
 * Quick union is using a root array.
 * Check if two index have the same root value
 * 
 * @author nz026920
 * 
 */
public class QuickUnion {

    private final int n;
    private final int[] root;

    public QuickUnion(final int n) {
        this.n = n;
        root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
    }

    public boolean connected(final int p, final int q) {
        return root(p) == root(q);
    }

    /**
     * union only need one step
     * 
     * @param p
     * @param q
     */
    public void union(final int p, final int q) {
        final int rootP = root(p);
        final int rootQ = root(q);
        if (rootP == rootQ) {
            return;
        }
        root[rootP] = rootQ;
    }

    /**
     * find the base root
     * 
     * @param value
     * @return
     */
    public int root(int value) {
        while (value != root(value)) {
            value = root[value];
        }
        return value;
    }

}
