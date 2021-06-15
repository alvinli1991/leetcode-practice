//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。 
//
// 
//
// 示例： 
//
// 
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
// 👍 133 👎 0


package me.alvin.leetcode.editor.cn;

import java.util.Arrays;

public class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {
    public static void main(String[] args) {
        Solution solution = new DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
        System.out.println(Arrays.toString(solution.exchange(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(solution.exchange(new int[]{1, 3, 5, 8})));
        System.out.println(Arrays.toString(solution.exchange(new int[]{2, 4, 6})));
        System.out.println(Arrays.toString(solution.exchange(new int[]{1, 11, 14})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] exchange(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                if (left < nums.length - 1 && nums[left] % 2 == 1) {
                    left++;
                    continue;
                }
                if (right > 0 && nums[right] % 2 == 0) {
                    right--;
                    continue;
                }
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
            return nums;
        }

        public int[] exchange2(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                while (left < nums.length - 1 && nums[left] % 2 == 1) {
                    left++;
                }
                while (right > 0 && nums[right] % 2 == 0) {
                    right--;
                }
                if (left < right) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                    left++;
                    right--;
                }
            }
            return nums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}