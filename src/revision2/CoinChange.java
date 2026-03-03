package revision2;

import java.util.Arrays;

public class CoinChange {

    public static int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {

            for (int coin : coins) {

                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {

        int[] coins1 = {1, 2, 5};
        int amount1 = 11;

        int[] coins2 = {2};
        int amount2 = 3;

        System.out.println(coinChange(coins1, amount1)); // 3
        System.out.println(coinChange(coins2, amount2)); // -1
    }
}
