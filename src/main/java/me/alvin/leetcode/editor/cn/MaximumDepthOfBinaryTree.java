//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 递归 
// 👍 883 👎 0


package me.alvin.leetcode.editor.cn;

import support.TreeNode;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
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
        int max;

        public int maxDepth(TreeNode root) {
            max = 0;
            dfs(root);
            return max;
        }

        /**
         * 根节点到最远叶子节点的最长路径上的节点数
         *
         * @param root
         * @return
         */
        public int dfs(TreeNode root) {
            if (null == root) {
                return 0;
            }
            int left = dfs(root.left);
            int right = dfs(root.right);
            //因为以root为节点的最大深度不包含节点本身，所以+1
            int depth = Math.max(left, right) + 1;
            max = Math.max(max, depth);
            return depth;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}