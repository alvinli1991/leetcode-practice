//路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不
//一定经过根节点。 
//
// 路径和 是路径中各节点值的总和。 
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
//
// 
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 104] 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 962 👎 0


package me.alvin.leetcode.editor.cn;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeMaximumPathSum().new Solution();
        TreeNode node_10 = new TreeNode(-10);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node_10.left = node9;
        node_10.right = node20;
        node20.left = node15;
        node20.right = node7;
        System.out.println(solution.maxPathSum(node_10));
        System.out.println(solution.path);

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int maxValue;
        public List<Integer> path;

        public int maxPathSum(TreeNode root) {
            path = new LinkedList<>();
            maxValue = Integer.MIN_VALUE;
            maxDownPathSum(root);
            return maxValue;
        }

        private int maxDownPathSum(TreeNode node) {
            if (node == null) return 0;
            int left = Math.max(0, maxDownPathSum(node.left));
            int right = Math.max(0, maxDownPathSum(node.right));
            maxValue = Math.max(maxValue, left + right + node.val);
            return Math.max(left, right) + node.val;
        }

//        /**
//         * TODO 返回路径
//         *
//         * @param node
//         * @return
//         */
//        private Pair<Integer, List<Integer>> maxDownPath(TreeNode node) {
//
//            if (node == null) return new Pair<>(0, new LinkedList<>());
//            Pair<Integer, List<Integer>> leftPair = maxDownPath(node.left);
//            Pair<Integer, List<Integer>> rightPair = maxDownPath(node.right);
//            int left = Math.max(0, leftPair.getKey());
//            int right = Math.max(0, rightPair.getKey());
//
//            int currentValue = left + right + node.val;
//            if (currentValue > maxValue) {
//                maxValue = currentValue;
//                path.add(node.val);
//            }
//            maxValue = Math.max(maxValue, currentValue);
//
//            return Math.max(left, right) + node.val;
//        }
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