//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 动态规划 
// 👍 1366 👎 0


package me.alvin.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {
    public static void main(String[] args) {
        Solution solution = new HouseRobber().new Solution();
        System.out.println(solution.rob2(new int[]{1, 2, 3, 1}));
        solution = new HouseRobber().new Solution();
        System.out.println(solution.rob(new int[]{2,7,9,3,1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            int max = 0;
            int[] dp = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (0 == i) {
                    max = nums[0];
                } else if (1 == i) {
                    max = Math.max(max, Math.max(nums[0], nums[1]));
                } else {
                    /**
                     *
                     * max(0) = nums[0]
                     * max(1) = max{nums[0],nums[1]}
                     * max(n):
                     *     nums[n] + max(n-2) 选n时
                     *     max(n-1) 不选n
                     */
                    max = Math.max(max, Math.max(dp[i - 1], nums[i] + dp[i - 2]));
                }
                dp[i] = max;
            }
            return max;
        }

        public int rob2(int[] nums) {
            int max = 0;
            Map<Integer, Integer> memo = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (0 == i) {
                    max = Math.max(max, nums[0]);
                } else if (1 == i) {
                    max = Math.max(nums[0], nums[1]);
                } else {
                    max = Math.max(memo.get(i - 1), nums[i] + memo.get(i - 2));
                }
                memo.put(i, max);
            }
            return max;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}