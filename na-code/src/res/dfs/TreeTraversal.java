package res.dfs;

import java.util.*;

/**
 * Created by na on 1/15/2015.
 * Use Binary Tree as an illustration
 */
public class TreeTraversal {

    public void DFS(TreeNode root) {

        if(root == null) {
            System.out.println("empty tree");
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.print(node.value + " ");

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        System.out.println();
    }

    public void BFS(TreeNode root) {
        if (root == null) {
            System.out.println("empty tree");
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.value + " ");

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> values = new ArrayList<Integer>();
        values.add(5);
        values.add(8);
        values.add(3);
        values.add(7);
        values.add(9);
        values.add(13);
        values.add(9);
        values.add(1);
        TreeTraversal dfs = new TreeTraversal();
        TreeNode root = new Tree().makeTree(values);
        dfs.DFS(root);
        dfs.BFS(root);

    }
}
