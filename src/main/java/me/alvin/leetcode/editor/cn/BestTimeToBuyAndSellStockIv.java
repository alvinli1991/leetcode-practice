//给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 2, prices = [2,4,1]
//输出：2
//解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。 
//
// 示例 2： 
//
// 
//输入：k = 2, prices = [3,2,6,5,0,3]
//输出：7
//解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 
//。 
//
// 
//
// 提示： 
//
// 
// 0 <= k <= 100 
// 0 <= prices.length <= 1000 
// 0 <= prices[i] <= 1000 
// 
// Related Topics 动态规划 
// 👍 499 👎 0


package me.alvin.leetcode.editor.cn;

public class BestTimeToBuyAndSellStockIv {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIv().new Solution();
//        System.out.println(solution.maxProfit(1, new int[]{1, 2}));
        System.out.println(solution.maxProfit(2, new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int k, int[] prices) {
            int days = prices.length;
            if (days <= 1) return 0;
            k = Math.min(k, days / 2);

            int[][][] dp = new int[days][2][k + 1];
            for (int tradeCount = 0; tradeCount <= k; tradeCount++) {
                dp[0][0][tradeCount] = 0;
                dp[0][1][tradeCount] = -prices[0];
            }

            for (int i = 1; i < days; i++) {
                for (int tradeCount = 1; tradeCount <= k; tradeCount++) {
                    dp[i][0][tradeCount] = Math.max(dp[i - 1][0][tradeCount], dp[i - 1][1][tradeCount] + prices[i]);
                    dp[i][1][tradeCount] = Math.max(dp[i - 1][1][tradeCount], dp[i - 1][0][tradeCount - 1] - prices[i]);
                }
            }
            return dp[days - 1][0][k];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}