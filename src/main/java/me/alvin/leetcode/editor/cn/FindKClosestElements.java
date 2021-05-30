//给定一个排序好的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。 
//
// 整数 a 比整数 b 更接近 x 需要满足： 
//
// 
// |a - x| < |b - x| 或者 
// |a - x| == |b - x| 且 a < b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = 3
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = -1
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= arr.length 
// 1 <= arr.length <= 104 
// 数组里的每个元素与 x 的绝对值不超过 104 
// 
// Related Topics 二分查找 
// 👍 212 👎 0


package me.alvin.leetcode.editor.cn;

import java.util.*;

public class FindKClosestElements {
    public static void main(String[] args) {
        Solution solution = new FindKClosestElements().new Solution();
        System.out.println(solution.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
        System.out.println(solution.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
            for (int i = 0; i < arr.length; i++) {
                int abs = Math.abs(x - arr[i]);
                if (pq.size() < k) {
                    pq.offer(new int[]{abs, arr[i]});
                } else if (pq.peek()[0] > abs) {
                    pq.poll();
                    pq.offer(new int[]{abs, arr[i]});
                }
            }
            Integer[] result = new Integer[k];
            for (int i = k - 1; i >= 0; i--) {
                result[i] = pq.poll()[1];
            }
            List<Integer> list = Arrays.asList(result);
            Collections.sort(list);
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}