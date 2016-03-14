package design.exercise3;

import java.util.Arrays;

import design.exercise3.util.TreeNode;

/**
 * 3-11. Suppose that we are given a sequence of n values x1, x2, ..., xn and seek to
 * quickly answer repeated queries of the form: given i and j, find the smallest value
 * in xi, . . . , xj .
 * (a) Design a data structure that uses O(n2) space and answers queries in O(1)
 * time.
 * (b) Design a data structure that uses O(n) space and answers queries in O(log n)
 * time. For partial credit, your data structure can use O(n log n) space and have
 * O(log n) query time.
 * 
 * (I didn't consider the time/space used to build this data structure. This issue only asks for the time/space cost by
 * using the built data structure)
 * 
 * @author nz026920
 * 
 */
public class FindSmallestValue {

    // build nXn look up table(2-dimension array) to store the answer
    // O(n^2) space and O(1) look up
    public void findValue(final int[] input) {

        Arrays.sort(input);

        final int[][] lookup = new int[input.length][];

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                lookup[i][j] = input[i];
            }
        }
    }

    // build a binary tree with answer on each node
    // used n nodes, so space is O(n). query time is O(log(n))
    public void findValue_tree(final int[] input) {
        Arrays.sort(input);
        buildBinaryTree(input);

    }

    private TreeNode buildBinaryTree(final int[] input) {
        final int length = input.length;
        final TreeNode root = new TreeNode(input[0], null, null);
        final int[] leftArray = Arrays.copyOf(input, length / 2);
        final int[] rightArray = Arrays.copyOfRange(input, input[length / 2], input[length - 1]);
        root.left = buildBinaryTree(leftArray);
        root.right = buildBinaryTree(rightArray);
        return root;
    }

}
