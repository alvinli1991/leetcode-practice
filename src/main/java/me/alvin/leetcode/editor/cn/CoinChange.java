//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 动态规划 
// 👍 1220 👎 0


package me.alvin.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(solution.coinChange(new int[]{2}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        HashMap<Integer, Integer> memo = new HashMap<>();

        public int coinChange(int[] coins, int amount) {
            return dpArray(coins, amount);
        }


        /**
         * dp(amount) -> count
         * amount count
         * 0      0
         * <0      -1
         * >0      min{dp(amount-coin) +1 | coin ∈ coins }
         *
         * @param coins
         * @param amount
         * @return
         */
        public int dp(int[] coins, int amount) {
            if (amount == 0) {
                return 0;
            }
            if (amount < 0) {
                return -1;
            }
            int result = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (memo.containsKey(amount)) {
                    return memo.get(amount);
                }
                int subResult = dp(coins, amount - coin);
                if (-1 == subResult) {
                    continue;
                }
                result = Math.min(result, subResult + 1);
            }
            memo.putIfAbsent(amount, result != Integer.MAX_VALUE ? result : -1);

            return memo.get(amount);
        }

        /**
         * dp[amount] = count
         * 当目标金额是amount时，最少需要的硬币数量为count
         *
         * @param coins
         * @param amount
         * @return
         */
        public int dpArray(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            //因为无论如何也不可能超过amount+1，例如只有面值为1的硬币
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            //推进dp数组
            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    if (i - coin < 0) continue;
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
            //记得如果无法选择，则需要排除不可能的值
            return dp[amount] != amount + 1 ? dp[amount] : -1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}