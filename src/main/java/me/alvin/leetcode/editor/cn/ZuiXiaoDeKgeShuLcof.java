//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 245 👎 0


package me.alvin.leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ZuiXiaoDeKgeShuLcof {
    public static void main(String[] args) {
        Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
//        System.out.println(Arrays.toString(solution.getLeastNumbers(new int[]{3, 2, 1}, 2)));
//        System.out.println(Arrays.toString(solution.getLeastNumbers(new int[]{0, 1, 2, 1}, 1)));
        System.out.println(Arrays.toString(solution.getLeastNumbers(new int[]{0, 0, 0, 2, 0, 5}, 0)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            //在此种解法时，必须增加
            if (k < 1 || arr.length < k) {
                return new int[0];
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for (int val : arr) {
                if (pq.size() < k) {
                    pq.offer(val);
                } else if (pq.peek() > val) {
                    pq.poll();
                    pq.offer(val);
                }
            }
            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = pq.poll();
            }
            return result;
        }

        public int[] getLeastNumbers2(int[] arr, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for (int val : arr) {
                pq.offer(val);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = pq.poll();
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}