package design.exercise3.util;

public class BST {

    public TreeNode root;

    public BST()
    {
        root = null;
    }

    /**
     * Insert into the tree; duplicates are ignored.
     * 
     * @param x
     *            the item to insert.
     */
    public void insert(final long x)
    {
        root = insert(x, root);
    }

    /**
     * Remove from the tree. Nothing is done if x is not found.
     * 
     * @param x
     *            the item to remove.
     */
    public void remove(final long x)
    {
        root = remove(x, root);
    }

    // /**
    // * Find the smallest item in the tree.
    // *
    // * @return smallest item or null if empty.
    // */
    // public Comparable findMin()
    // {
    // return elementAt(findMin(root));
    // }
    //
    // /**
    // * Find the largest item in the tree.
    // *
    // * @return the largest item of null if empty.
    // */
    // public Comparable findMax()
    // {
    // return elementAt(findMax(root));
    // }
    //
    // /**
    // * Find an item in the tree.
    // *
    // * @param x
    // * the item to search for.
    // * @return the matching item or null if not found.
    // */
    // public Comparable find(final Comparable x)
    // {
    // return elementAt(find(x, root));
    // }
    //
    // /**
    // * Make the tree logically empty.
    // */
    // public void makeEmpty()
    // {
    // root = null;
    // }

    /**
     * Test if the tree is logically empty.
     * 
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return root == null;
    }

    // /**
    // * Print the tree contents in sorted order.
    // */
    // public void printTree()
    // {
    // if (isEmpty()) {
    // System.out.println("Empty tree");
    // } else {
    // printTree(root);
    // }
    // }
    //
    // /**
    // * Internal method to get element field.
    // *
    // * @param t
    // * the node.
    // * @return the element field or null if t is null.
    // */
    // private Comparable elementAt(final BinaryNode t)
    // {
    // return t == null ? null : t.element;
    // }

    /**
     * Internal method to insert into a subtree.
     * 
     * @param x
     *            the item to insert.
     * @param t
     *            the node that roots the tree.
     * @return the new root.
     */
    private TreeNode insert(final long x, TreeNode t)
    {
        if (t == null) {
            t = new TreeNode(x, null, null);
        } else if (x < t.value) {
            insert(x, t.left);
        } else if (x > t.value) {
            insert(x, t.right);
        }
        else {
            // Duplicate; do nothing
        }
        return t;
    }

    public TreeNode lift(long x, final TreeNode t)
    {
        if (t.right == null) {
            x = t.value;
            return t.left;
        } else {
            t.right = lift(x, t.right);
            return t;
        }
    }

    /**
     * Internal method to remove from a subtree.
     * 
     * @param x
     *            the item to remove.
     * @param t
     *            the node that roots the tree.
     * @return the new root.
     */
    private TreeNode remove(final long x, TreeNode t) {

        if (t == null) {
            return t;   // Item not found; do nothing
        } else if (x < t.value) {
            remove(x, t.left);
        } else if (x > t.value) {
            remove(x, t.right);
        } else if (t.left != null && t.right != null) {
            t.value = findMin(t.right).value;
            remove(t.value, t.right);
        } else {
            t = (t.left != null) ? t.left : t.right;
        }
        return t;
    }

    /**
     * Internal method to find the smallest item in a subtree.
     * 
     * @param t
     *            the node that roots the tree.
     * @return node containing the smallest item.
     */
    private TreeNode findMin(final TreeNode t)
    {
        if (t == null) {
            return null;
        } else if (t.left == null) {
            return t;
        }
        return findMin(t.left);
    }

    // /**
    // * Internal method to find the largest item in a subtree.
    // *
    // * @param t
    // * the node that roots the tree.
    // * @return node containing the largest item.
    // */
    // private BinaryNode findMax(BinaryNode t)
    // {
    // if (t != null) {
    // while (t.right != null) {
    // t = t.right;
    // }
    // }
    //
    // return t;
    // }
    //
    // /**
    // * Internal method to find an item in a subtree.
    // *
    // * @param x
    // * is item to search for.
    // * @param t
    // * the node that roots the tree.
    // * @return node containing the matched item.
    // */
    // private BinaryNode find(final Comparable x, final BinaryNode t)
    // {
    // if (t == null) {
    // return null;
    // }
    // if (x.compareTo(t.element) < 0) {
    // return find(x, t.left);
    // } else if (x.compareTo(t.element) > 0) {
    // return find(x, t.right);
    // }
    // else {
    // return t; // Match
    // }
    // }
    //
    // /**
    // * Internal method to print a subtree in sorted order.
    // *
    // * @param t
    // * the node that roots the tree.
    // */
    // private void printTree(final BinaryNode t)
    // {
    // if (t != null)
    // {
    // printTree(t.left);
    // System.out.println(t.element);
    // printTree(t.right);
    // }
    // }

}

// class TreeNode {
// long value;
// TreeNode left;
// TreeNode right;
//
// public TreeNode(final long value, final TreeNode left, final TreeNode right) {
// this.value = value;
// this.left = left;
// this.right = right;
//
// }
// }
