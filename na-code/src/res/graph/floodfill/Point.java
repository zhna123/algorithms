package res.graph.floodfill;

public class Point {

    private final int x;
    private final int y;
    private final int color;

    public Point(final int x, final int y, final int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
