//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 143 👎 0


package me.alvin.leetcode.editor.cn;

public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
        System.out.println(solution.search(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            //寻找右边界
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] == target) {
                    left = mid + 1;
                }
            }
            if (right < 0 || nums[right] != target) {
                return 0;
            }
            //右边界，包含
            int rightGuard = right;
            //寻找左边界
            left = 0;
            right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] == target) {
                    right = mid - 1;
                }
            }
            if (left >= nums.length || nums[left] != target) {
                return 0;
            }
            //左边界包含
            int leftGuard = left;
            return rightGuard - leftGuard + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}