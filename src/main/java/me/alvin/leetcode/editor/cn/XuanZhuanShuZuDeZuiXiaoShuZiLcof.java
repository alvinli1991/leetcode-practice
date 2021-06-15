//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2
//] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
//
// 示例 1： 
//
// 输入：[3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 输入：[2,2,2,0,1]
//输出：0
// 
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sor
//ted-array-ii/ 
// Related Topics 二分查找 
// 👍 330 👎 0


package me.alvin.leetcode.editor.cn;

public class XuanZhuanShuZuDeZuiXiaoShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new XuanZhuanShuZuDeZuiXiaoShuZiLcof().new Solution();
//        System.out.println(solution.minArray(new int[]{1, 2, 3, 4, 5}));
//        System.out.println(solution.minArray(new int[]{3, 4, 5, 1, 2}));
        System.out.println(solution.minArray(new int[]{1, 0, 1, 1, 1}));
//        System.out.println(solution.minArray(new int[]{1, 1, 1, 0, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minArray(int[] numbers) {
            int length = numbers.length;
            if (0 == length) {
                return 0;
            }
            int left = 0;
            int right = length - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (numbers[mid] > numbers[right]) {
                    // 下一轮搜索区间是 [mid + 1, right]
                    left = mid + 1;
                } else if (numbers[mid] == numbers[right]) {
                    // 只能把 right 排除掉，下一轮搜索区间是 [left, right - 1]
                    right = right - 1;
                } else {
                    // 此时 numbers[mid] < numbers[right]
                    // mid 的右边一定不是最小数字，mid 有可能是，下一轮搜索区间是 [left, mid]
                    right = mid;
                }
            }
            return numbers[left];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}