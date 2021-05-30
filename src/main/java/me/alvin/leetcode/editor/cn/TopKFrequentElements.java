//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
// Related Topics 堆 哈希表 
// 👍 762 👎 0


package me.alvin.leetcode.editor.cn;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1}, 1)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> frequence = new HashMap<>(nums.length);
            for (int num : nums) {
                frequence.put(num, frequence.getOrDefault(num, 0) + 1);
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
            for (Map.Entry<Integer, Integer> kv : frequence.entrySet()) {
                if (pq.size() < k) {
                    pq.offer(new int[]{kv.getValue(), kv.getKey()});
                } else if (kv.getValue() > pq.peek()[0]) {
                    pq.poll();
                    pq.offer(new int[]{kv.getValue(), kv.getKey()});
                }
            }
            int[] result = new int[pq.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = pq.poll()[1];
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}