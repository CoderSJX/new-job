public class MaxProfitWithSeveralTimes {
    private int res;

    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length < 2) return 0;
        res = 0;
        dfs(prices, 0, length, 0, res);
        return res;
    }

    private void dfs(int[] prices, int index, int len, int status, int profit) {
        if (index == len) {
            res = Math.max(res, profit);
            return;
        }

        dfs(prices, index + 1, len, status, profit);
        if (status == 0) {
            dfs(prices, index + 1, len, 1, profit - prices[index]);
        } else {
            dfs(prices, index + 1, len, 0, profit + prices[index]);
        }
    }

    public int maxProfit2(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            if (diff > 0) {
                res += diff;
            }
        }
        return res;
    }


    public int maxProfit3(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        // 0：持有现金
        // 1：持有股票
        // 状态转移：0 → 1 → 0 → 1 → 0 → 1 → 0
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            // 这两行调换顺序也是可以的
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }

}
