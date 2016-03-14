package design.exercise3;

import design.exercise3.util.TreeNode;

/**
 * 3-9
 * Given 2 binary trees, s1 and s2
 * every element in s1 is less than all elements in s2
 * design an algorithm to combine them to a new binary search tree with O(h)
 * (h is the max height of the 2 trees)
 * 
 * 1. find the max of s1 or min of s2
 * 2. set this element as root
 * 3. update its pointers to point to root of s1 on the left pointer and root of s2 on the right pointer
 * this algorithm takes O(h) because of the operation of finding the min/max of a tree
 * 
 * @author nz026920
 * 
 */
public class ConcentrateBinaryTrees {

    public TreeNode findMinimum(final TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root;
        }
        return findMinimum(root.left);
    }

    public TreeNode combine(final TreeNode s1, final TreeNode s2) {
        final TreeNode minOfS2 = findMinimum(s2);
        minOfS2.left = s1;
        minOfS2.right = s2;
        return minOfS2;
    }
}
