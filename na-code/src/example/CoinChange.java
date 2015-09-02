package example;

/**
 * classic DP
 * example question:
 * if we 1-dollar, 3-dollar and 5-dollar coins, how to use the minimum number of coins to get 11 dollars
 * 
 * Extension: The difference between DP and Greedy.
 * Greedy might not get the optimal solution. It is not suitable to min/max type of questions
 * if we change 1-dollar to 2-dollar in above problem, using greedy can't get a solution
 * 
 * Another example: 1-dollar, 3-dollar, 4-dollar to get 6 dollars
 * using greedy we get: 6/4=1....2; 2/1=2 so we need one 4-dollar, two 1-dollar, total is 3 coins
 * but the optimal solution, obviously, is 2 coins (two 3-dollar coins)
 * 
 * state: d(i) represent the minimum number of coins used to get i dollars
 * equation: d(i) = min{d(i - vj) + 1} (vj is the value of coin j)
 * 
 */
public class CoinChange {

    private static void makeChange(final int values[], final int types, int total, final int coinUsed[], final int coinTrack[]) {
        coinUsed[0] = 0;
        coinTrack[0] = 0;

        for (int i = 1; i <= total; i++) {
            int minCoin = i;
            int coin = 0;
            // try each type of coin to see which one give us the min number of coins
            // use the saved value of the previous operation
            for (int j = 0; j < types; j++) {
                if (values[j] <= i) {
                    if (coinUsed[i - values[j]] + 1 < minCoin) {
                        minCoin = coinUsed[i - values[j]] + 1;
                        coin = values[j];
                    }
                }
            }
            coinUsed[i] = minCoin;
            // get the coin used
            // this array records all the j value we chose(which would make the min number) for each amount from 1 to
            // total
            coinTrack[i] = coin;
        }

        System.out.println("the min number of coins to get " + total + " dollars is " + coinUsed[total]);

        // print out the coins used(optional; use an extra array)
        while (total > 0) {
            System.out.println(coinTrack[total]);
            total -= coinTrack[total];
        }
    }

    public static void main(final String[] args) {
        final int values[] = { 2, 3, 5 };
        final int size = values.length;
        final int money = 11;
        makeChange(values, size, money, new int[money + 1], new int[money + 1]);
    }

    // greedy algorithm (only a reference)
    // real RMB can use greedy to get optimal solution
    public static int[] greedyMoneyChange(final int m[], int n)
    {
        final int k = m.length;
        final int[] num = new int[k];
        for (int i = 0; i < k; i++)
        {
            num[i] = n / m[i];
            n = n % m[i];
        }
        return num;
    }

}
