//找出数组中重复的数字。 
//
// 
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。 
//
// 示例 1： 
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
// 
//
// 
//
// 限制： 
//
// 2 <= n <= 100000 
// Related Topics 数组 哈希表 
// 👍 451 👎 0


package me.alvin.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ShuZuZhongZhongFuDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongZhongFuDeShuZiLcof().new Solution();
        System.out.println(solution.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findRepeatNumber(int[] nums) {
            return exchange(nums);
        }

        public int hashMap(int[] nums) {
            Map<Integer, Integer> numCount = new HashMap();
            for (int i = 0; i < nums.length; i++) {
                int holder = nums[i];
                numCount.put(holder, numCount.getOrDefault(holder, 0) + 1);
                if (numCount.get(holder) > 1) {
                    return holder;
                }
            }
            return -1;
        }

        public int hashSet(int[] nums) {
            Set<Integer> numCount = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                int holder = nums[i];
                if (numCount.contains(holder)) {
                    return holder;
                }
                numCount.add(holder);
            }
            return -1;
        }

        /**
         * 通过下标交换
         * @param nums
         * @return
         */
        public int exchange(int[] nums) {
            int i = 0;
            while (i < nums.length) {
                int num = nums[i];
                if (num == i) {
                    i++;
                    continue;
                }
                if (num == nums[num]) {
                    return num;
                }
                int tmp = nums[num];
                nums[num] = num;
                nums[i] = tmp;
            }
            return -1;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}