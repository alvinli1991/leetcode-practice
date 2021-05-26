//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。 
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
// 
//
// 说明 : 
//
// 
// 数组的长度为 [1, 20,000]。 
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。 
// 
// Related Topics 数组 哈希表 
// 👍 905 👎 0


package me.alvin.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK().new Solution();
//        System.out.println(solution.subarraySum(new int[]{1, 1, 1,1}, 2));
//        System.out.println(solution.subarraySum(new int[]{-1, -1, 1}, 0));
        System.out.println(solution.subarraySum(new int[]{1, -1, 0}, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> preSumCount = new HashMap<>();
            preSumCount.put(0, 1);
            int resultCount = 0;
            int currentSum = 0;
            for (int i = 0; i < nums.length; i++) {
                currentSum += nums[i];
                int requiredPreSum = currentSum - k;
                resultCount += preSumCount.getOrDefault(requiredPreSum, 0);
                preSumCount.put(currentSum, preSumCount.getOrDefault(currentSum, 0) + 1);
            }
            return resultCount;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}