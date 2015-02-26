package res.graph.floodfill;


/**
 * This is an illustration of 4-way flood fill algorithm
 * 
 * @author nz026920
 * 
 */
public class FloodFill {

    private final int width;
    private final int height;
    private final int[][] screenBuffer;

    // screenBuffer is used to store graph color pixels
    public FloodFill(final int[][] screenBuffer) {
        this.width = screenBuffer[0].length;
        this.height = screenBuffer.length;
        this.screenBuffer = screenBuffer;
    }

    public void floodfillRecursion(final int x, final int y, final int newColor, final int oldColor) {

        if (x >= 0 && x < width && y >= 0 && y < height && screenBuffer[x][y] == oldColor && screenBuffer[x][y] != newColor) {

            screenBuffer[x][y] = newColor;

            floodfillRecursion(x + 1, y, newColor, oldColor);
            floodfillRecursion(x - 1, y, newColor, oldColor);
            floodfillRecursion(x, y + 1, newColor, oldColor);
            floodfillRecursion(x, y - 1, newColor, oldColor);
        }
    }
}
