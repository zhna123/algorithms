package res.graph.floodfill;

public class Point {

    private final int x;
    private final int y;
    private int color;

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getColor() {
        return color;
    }

    public void setColor(final int color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
