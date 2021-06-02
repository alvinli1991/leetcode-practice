//给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
//
// 
//
// 
// 
//
// 示例 1: 
//
// 输入: amount = 5, coins = [1, 2, 5]
//输出: 4
//解释: 有四种方式可以凑成总金额:
//5=5
//5=2+2+1
//5=2+1+1+1
//5=1+1+1+1+1
// 
//
// 示例 2: 
//
// 输入: amount = 3, coins = [2]
//输出: 0
//解释: 只用面额2的硬币不能凑成总金额3。
// 
//
// 示例 3: 
//
// 输入: amount = 10, coins = [10] 
//输出: 1
// 
//
// 
//
// 注意: 
//
// 你可以假设： 
//
// 
// 0 <= amount (总金额) <= 5000 
// 1 <= coin (硬币面额) <= 5000 
// 硬币种类不超过 500 种 
// 结果符合 32 位符号整数 
// 
// 👍 405 👎 0


package me.alvin.leetcode.editor.cn;

public class CoinChange2 {
    public static void main(String[] args) {
        Solution solution = new CoinChange2().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int change(int amount, int[] coins) {
            //前i个硬币，凑出总金额为amount时的组合数
            int coinCount = coins.length;
            int[][] dp = new int[coinCount + 1][amount + 1];
            for (int i = 0; i <= coinCount; i++) {
                dp[i][0] = 1;
            }
            for (int i = 1; i <= coinCount; i++) {
                for (int j = 1; j <= amount; j++) {
                    if (j - coins[i - 1] >= 0) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[coinCount][amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}