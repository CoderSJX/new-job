public class MaxProfit3 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int dp[][] = new int[len][4];
        for (int i = 0; i < len; i++) {
            dp[i][3] = Integer.MIN_VALUE;
        }
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = 0;
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][2]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return Math.max(dp[len - 1][0], Math.max(dp[len - 1][2], dp[len - 1][4]));
    }
}
