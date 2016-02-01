//LeetCode#332: Coin Change
//Runtime: 26ms
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int types = coins.length;
        int[] f = new int[amount + 1];
        f[0] = 0;
        for (int i = 1; i <= amount; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 0; j < types; j++) {
                if (i < coins[j] || f[i - coins[j]] == Integer.MAX_VALUE)
                    continue;
                else
                    f[i] = Integer.min(f[i], f[i - coins[j]] + 1);
            }
        }
        if (f[amount] == Integer.MAX_VALUE)
            return -1;
        else
            return f[amount];
    }
}