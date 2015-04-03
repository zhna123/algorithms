package res.graph.floodfill;

import java.util.Stack;

public class FloodFill2 {

    private final int width;
    private final int height;
    private final int[][] screenBuffer;

    public FloodFill2(final int[][] screenBuffer) {
        this.width = screenBuffer[0].length;
        this.height = screenBuffer.length;
        this.screenBuffer = screenBuffer;
    }

    /**
     * Using stack. Created a type Point to store pixels and colors.
     * 
     * @param x
     * @param y
     * @param newColor
     * @param oldColor
     */
    public void floodfillStack(final int x, final int y, final int newColor, final int oldColor) {
        if (oldColor == newColor) {
            return;
        }
        if (x >= width || y >= height) {
            return;
        }
        final Stack<Point> stack = new Stack<Point>();
        stack.push(new Point(x, y, screenBuffer[x][y]));
        while (!stack.isEmpty()) {
            final Point p = stack.pop();
            screenBuffer[p.getX()][p.getY()] = newColor;

            if (p.getX() + 1 < height) {
                final Point p1 = new Point(p.getX() + 1, p.getY(), screenBuffer[p.getX() + 1][p.getY()]);
                if (p1.getColor() == oldColor) {
                    stack.push(p1);
                }
            }

            if (p.getX() - 1 >= 0) {
                final Point p2 = new Point(p.getX() - 1, p.getY(), screenBuffer[p.getX() - 1][p.getY()]);
                if (p2.getColor() == oldColor) {
                    stack.push(p2);
                }
            }

            if (p.getY() + 1 < width) {
                final Point p3 = new Point(p.getX(), p.getY() + 1, screenBuffer[p.getX()][p.getY() + 1]);
                if (p3.getColor() == oldColor) {
                    stack.push(p3);
                }
            }

            if (p.getY() - 1 >= 0) {
                final Point p4 = new Point(p.getX(), p.getY() - 1, screenBuffer[p.getX()][p.getY() - 1]);
                if (p4.getColor() == oldColor) {
                    stack.push(p4);
                }
            }

        }
    }

}
