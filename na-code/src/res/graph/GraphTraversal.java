package res.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphTraversal {

    boolean[] visited;
    Graph g;

    public GraphTraversal(final int[][] matrix) {
        g = new Graph(matrix);
        visited = new boolean[g.getNumberOfNodes()];
    }

    public void DFS() {

        final int rootNode = 0;
        final Stack<Integer> stack = new Stack<Integer>();
        stack.push(rootNode);
        visited[rootNode] = true;
        printNodes(rootNode);
        while (!stack.isEmpty()) {
            // using peek is because there might be lots of unvisited child nodes, so we shouldn't remove the node
            // yet.We
            // only remove it if there is no child node anymore
            final int n = stack.peek();
            final int child = getUnvisitedChildNode(n, g);
            if (child != -1) {
                visited[child] = true;
                printNodes(child);
                stack.push(child);
            } else {
                stack.pop();
            }
        }
        clearVisited(visited);
    }

    private void clearVisited(final boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
    }

    public void BFS() {
        final int rootNode = 0;
        final Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(rootNode);
        visited[rootNode] = true;
        printNodes(rootNode);
        while (!queue.isEmpty()) {
            final int n = queue.peek();
            final int child = getUnvisitedChildNode(n, g);
            if (child != -1) {
                visited[child] = true;
                printNodes(child);
                queue.add(child);
            } else {
                queue.poll();
            }
        }
        clearVisited(visited);
    }

    private void printNodes(final int n) {
        System.out.println(n);
    }

    private int getUnvisitedChildNode(final int n, final Graph g) {
        for (int j = 0; j < g.getNumberOfNodes(); j++) {
            if (g.getAdjMatrix()[n][j] > 0 && !visited[j]) {
                return j;
            }
        }
        return -1;
    }

}
