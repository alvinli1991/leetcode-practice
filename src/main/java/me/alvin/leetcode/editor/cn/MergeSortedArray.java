//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
//ms2 的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -109 <= nums1[i], nums2[i] <= 109 
// 
// Related Topics 数组 双指针 
// 👍 956 👎 0


package me.alvin.leetcode.editor.cn;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        int[] test1 = new int[] {1,2,3,0,0,0};
        solution.merge(test1,3,new int[]{2,5,6},3);
        System.out.println(Arrays.toString(test1));

        int[] test2 = new int[] {0};
        solution.merge(test2,0,new int[]{1},1);
        System.out.println(Arrays.toString(test2));

        int[] test3 = new int[] {1};
        solution.merge(test3,1,new int[]{},0);
        System.out.println(Arrays.toString(test3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int totalSize = m + n;
            int index1 = m - 1;
            int index2 = n - 1;
            //一边反向遍历长数组，一遍确定当时那个节点的值
            for (int i = totalSize - 1; i >= 0; i--) {
                if (index1 >= 0 && index2 >= 0) {
                    if(nums1[index1] >= nums2[index2]){
                        nums1[i] = nums1[index1];
                        index1--;
                    }else{
                        nums1[i] = nums2[index2];
                        index2--;
                    }
                } else if (index2 < 0) {
                    nums1[i] = nums1[index1];
                    index1--;
                } else {
                    nums1[i] = nums2[index2];
                    index2--;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}