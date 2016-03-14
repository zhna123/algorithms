package design.exercise3;

/**
 * 3-13. [5] Let A[1..n] be an array of real numbers. Design an algorithm to perform any
 * sequence of the following operations:
 * • Add(i,y) – Add the value y to the ith number.
 * • Partial-sum(i) – Return the sum of the first i numbers, i.e. i
 * j=1 A[j].
 * There are no insertions or deletions; the only change is to the values of the numbers.
 * Each operation should take O(log n) steps. You may use one additional array of size
 * n as a work space.
 * 
 * A better strategy using binary trees is as follows (took online):
 * 
 * Construct a balanced binary tree with n leaves; stick the elements along the bottom of the tree in their original
 * order.
 * 
 * Querying a partial-sum goes like this: Descend the tree towards the query (leaf) node, but whenever you descend
 * right, add the subtree-sum on the left, since we know for sure those elements are in the sum.
 * 
 * 
 * @author nz026920
 * 
 */
public class EXE13 {

    public int[] add(final int[] A, final int i, final int y) {
        // B is used for sums
        final int n = A.length;
        final int[] B = new int[n];
        final int used = (int) Math.round(Math.log(n) / Math.log(2));
        final int interval = used - 1;
        int sum = 0;
        int k = 0;

        A[i] = A[i] + y;

        for (int j = 0; j < n; j++) {
            sum = sum + B[j];
            k++;
            if (k == interval) {
                if (j + interval < n) {
                    if (i <= j + interval) {
                        sum = sum + y;
                    }
                    B[j + interval] = sum;
                    k = 0;
                    continue;
                } else {
                    break;
                }
            }
        }

        return A;
    }

    public long sum(final long[] A, final int i) {
        // check which sum i is close to, then plus or minus data as necessary
        return 0;
    }

}
