package res.graph;

public class Graph {

    private final int numberOfNodes;
    private final int[][] adjMatrix;

    public Graph(final int[][] matrix) {
        this.numberOfNodes = matrix.length;
        adjMatrix = new int[numberOfNodes][numberOfNodes];

        for (int i = 0; i < numberOfNodes; i++) {
            for (int j = 0; j < numberOfNodes; j++) {
                adjMatrix[i][j] = matrix[i][j];
            }
        }
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

}
