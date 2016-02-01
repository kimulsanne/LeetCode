//LeetCode#309: Best Time to Buy and Sell Stock with Cooldown
//Runtime: 3ms
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) 
            return 0;
        int days = prices.length;
        int[][] profit = new int[days][2]; // 0 for sell, 1 for cooldown
        profit[0][0] = 0;
        profit[0][1] = 0;
        for (int i = 1; i < days; i++) {
            profit[i][0] = Integer.max(profit[i - 1][0] + prices[i] - prices[i - 1], profit[i-1][1]);
            profit[i][1] = Integer.max(profit[i - 1][0], profit[i-1][1]);
        }
        return Integer.max(profit[days - 1][0], profit[days - 1][1]);
    }
}