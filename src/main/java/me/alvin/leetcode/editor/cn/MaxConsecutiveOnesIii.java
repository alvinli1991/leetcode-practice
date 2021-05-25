//给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。 
//
// 返回仅包含 1 的最长（连续）子数组的长度。 
//
// 
//
// 示例 1： 
//
// 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//输出：6
//解释： 
//[1,1,1,0,0,1,1,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 6。 
//
// 示例 2： 
//
// 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//输出：10
//解释：
//[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 10。 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 20000 
// 0 <= K <= A.length 
// A[i] 为 0 或 1 
// 
// Related Topics 双指针 Sliding Window 
// 👍 290 👎 0


package me.alvin.leetcode.editor.cn;


public class MaxConsecutiveOnesIii {
    public static void main(String[] args) {
        Solution solution = new MaxConsecutiveOnesIii().new Solution();
        System.out.println(solution.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0},2));//6
        System.out.println(solution.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1},3));//10
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestOnes(int[] nums, int k) {
            int left = 0;
            int right = 0;
            int max1Count = 0;
            //存储0，1的个数
            int[] numCounter = new int[2];

            int maxLength = 0;
            while (right < nums.length) {
                int addNum = nums[right];
                numCounter[addNum]++;
                right++;
                if (1 == addNum) {
                    max1Count = numCounter[addNum];
                }

                while (right - left > k + max1Count) {
                    int removeNum = nums[left];
                    numCounter[removeNum]--;
                    left++;
                    if (removeNum == 1) {
                        max1Count = numCounter[removeNum];
                    }
                }
                maxLength = Math.max(maxLength, right - left);
            }

            return maxLength;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}