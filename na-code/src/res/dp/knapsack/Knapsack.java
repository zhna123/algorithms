package res.dp.knapsack;

import java.util.ArrayList;

/**
 * Dynamic Programming example: Knapsack problem
 * 
 */
public class Knapsack {

    private final Gem[] gems;
    private final int maxWeight;

    private final int numberOfGems;
    // 这个数组定义状态. bestValues[i][j]表示前i个宝石装到剩余体积为j的背包里能达到的最大价值
    private final int[][] bestValues;

    private int bestValue;
    private ArrayList<Gem> bestSolution;

    public Knapsack(final Gem[] gems, final int maxWeight) {
        this.gems = gems;
        this.maxWeight = maxWeight;

        this.numberOfGems = gems.length;
        // 宝石的编号从0开始 所以0号宝石对应的状态应该是“前1个宝石装到。。。。。。。”
        // n号宝石对应的状态是“前n+1个宝石装到。。。。。。”
        // 所以这个状态数组需要n＋1 来表示前n个宝石。 weight也要＋1，不然算bestValue的时候就要数组出界了。
        bestValues = new int[numberOfGems + 1][maxWeight + 1];
    }

    public void solve() {
        for (int i = 0; i < numberOfGems + 1; i++) {
            for (int j = 0; j < maxWeight + 1; j++) {
                // 没有宝石和背包体积为0的情况，当然所能达到的最大价值是0
                if (i == 0 || j == 0) {
                    bestValues[i][j] = 0;
                } else {
                    // 如果第i个宝石的重量大于j，i宝石肯定不能装进来了，所以最大价值在前i-1个宝石里
                    if (j < gems[i - 1].getWeight()) {
                        bestValues[i][j] = bestValues[i - 1][j];
                    } else {
                        // 否则比较是装进i价值比较大还是不装i价值比较大。取大的那一个装
                        final int iweight = gems[i - 1].getWeight();
                        final int ivalue = gems[i - 1].getValue();
                        // 算法核心 状态转移方程
                        bestValues[i][j] = Math.max(bestValues[i - 1][j], ivalue + bestValues[i - 1][j - iweight]);
                    }
                }
            }
        }

        bestSolution = new ArrayList<Gem>();
        int currentWeight = maxWeight;
        for (int i = numberOfGems; i >= 1; i--) {
            // 如果前i个宝石装入背包后的总价值大于把前i-1装入的总价值 那么第i个宝石就装入了。注意第i个宝石是i-1
            // 相应的重量也要减去 直到重量为0
            if (bestValues[i][currentWeight] > bestValues[i - 1][currentWeight]) {
                bestSolution.add(gems[i - 1]);
                currentWeight -= gems[i - 1].getWeight();
            }
            if (currentWeight == 0) {
                break;
            }
        }
        bestValue = bestValues[numberOfGems][maxWeight];
    }

    public int[][] getBestValues() {
        return bestValues;
    }

    public ArrayList<Gem> getBestSolution() {
        return bestSolution;
    }

    public int getBestValue() {
        return bestValue;
    }

}
