//给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。 
//
// 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。 
//
// 
//
// 示例 1： 
//输入: 
//
//   5
// /  \
//2   -3
// 
//
// 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。 
//
// 示例 2： 
//输入： 
//
//   5
// /  \
//2   -5
// 
//
// 返回 [2]，只有 2 出现两次，-5 只出现 1 次。 
//
// 
//
// 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。 
// Related Topics 树 哈希表 
// 👍 107 👎 0


package me.alvin.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MostFrequentSubtreeSum {
    public static void main(String[] args) {
        Solution solution = new MostFrequentSubtreeSum().new Solution();
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(-5);

        node1.left = node2;
        node1.right = node3;

        System.out.println(Arrays.toString(solution.findFrequentTreeSum(node1)));

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        int maxCount = 0;

        public int[] findFrequentTreeSum(TreeNode root) {
            Map<Integer, Integer> treeSumCount = new HashMap<>();
            subTreeSum(root, treeSumCount);
            if (treeSumCount.isEmpty()) {
                return new int[]{};
            } else {
                return treeSumCount
                        .entrySet()
                        .stream()
                        .filter(entry -> entry.getValue() == maxCount)
                        .map(Map.Entry::getKey)
                        .distinct()
                        .mapToInt(i -> i)
                        .toArray();
            }
        }

        public int subTreeSum(TreeNode root, Map<Integer, Integer> treeSumCount) {
            if (null == root) {
                return 0;
            }
            int rootSum = root.val + subTreeSum(root.left, treeSumCount) + subTreeSum(root.right, treeSumCount);
            updateTreeSumCount(treeSumCount, rootSum);
            return rootSum;
        }

        public void updateTreeSumCount(Map<Integer, Integer> treeSumCount, int sum) {
            Integer count = treeSumCount.get(sum);
            if (null == count) {
                count = 1;
            } else {
                count++;
            }
            treeSumCount.put(sum, count);
            if (count > maxCount) {
                maxCount = count;
            }

        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}