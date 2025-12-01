package Practices.Week_2;

public class Q2_Stock {
    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;

        for (int price : prices) {
            min = Math.min(min, price);
            profit = Math.max(profit, price - min);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] p = {7,1,5,3,6,4};
        System.out.println(maxProfit(p));   // 5
    }
}
