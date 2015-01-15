package res.dfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by na on 1/15/2015.
 */
public class Tree {
    private List<Integer> values;
    private int index;
    public Tree() {

    }

    public TreeNode makeTree(List<Integer> values) {

        TreeNode root = new TreeNode(values.get(0), null, null);
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        nodes.add(root);
        int half = values.size()/2;

        for (int i=0; i<half; i++) {
            if (values.get(i) != null) {
                TreeNode node = nodes.poll();
                int left = 2 * i + 1;
                int right = 2 * i + 2;

                if (values.get(left) != null) {
                    node.left = new TreeNode(values.get(left), null, null);
                    nodes.add(node.left);
                }

                if (right < values.size() && values.get(right) != null) {
                    node.right = new TreeNode(values.get(right), null, null);
                    nodes.add(node.right);
                }
            }
        }
        return root;
    }
}
