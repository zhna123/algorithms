package res.dp.knapsack;

public class Gem {
    private final int weight;
    private final int value;

    public Gem(final int weight, final int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public int getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return "[weight: " + weight + "||value: " + value + "]";
    }
}
