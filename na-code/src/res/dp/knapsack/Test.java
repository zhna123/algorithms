package res.dp.knapsack;

public class Test {

    public static void main(final String[] args) {
        final Gem[] gems = new Gem[] {
                new Gem(2, 13), new Gem(1, 10),
                new Gem(3, 24), new Gem(2, 15),
                new Gem(4, 28), new Gem(5, 33),
                new Gem(3, 20), new Gem(1, 8)
        };

        final Gem[] gems2 = new Gem[] {
                new Gem(5, 20), new Gem(4, 10),
                new Gem(3, 12)
        };

        final int maxWeight = 12;
        final int maxWeight2 = 10;

        final Knapsack kp = new Knapsack(gems, maxWeight);
        kp.solve();

        System.out.println("---------------solution-------------------");
        System.out.println(kp.getBestSolution());
        System.out.println("-----------------best value---------------");
        System.out.println(kp.getBestValue());
    }

}
