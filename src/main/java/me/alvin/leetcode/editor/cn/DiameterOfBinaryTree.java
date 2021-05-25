//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 
// 👍 705 👎 0


package me.alvin.leetcode.editor.cn;

import support.TreeNode;
import support.TreeTools;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new DiameterOfBinaryTree().new Solution();
        System.out.println(solution.diameterOfBinaryTree(TreeTools.buildTree(new Integer[]{1,2,3,4,5,6},0)));
//        System.out.println(solution.diameterOfBinaryTree(TreeTools.buildTree(new Integer[]{1, 2, 3}, 0)));
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
        int maxDiameter;
        public int diameterOfBinaryTree(TreeNode root) {
            maxDiameter = 0;
            maxEdge(root);
            return maxDiameter;
        }
        /**
         * 以root为顶点，提供给父节点的最大半边的边数
         *
         * @param root
         * @return
         */
        private int maxEdge(TreeNode root) {
            //到触及到空节点，下面无edge
            if (null == root) {
                return 0;
            }

            //求左右节点的最大边数
            int left = maxEdge(root.left);
            int right = maxEdge(root.right);
            //在此处可以计算已root为节点，左右的边数
            maxDiameter = Math.max(maxDiameter, left + right);
            //由于左右半边不包含本节点，如果root节点要被父节点使用，那么它能提供的边数要机上自己与父节点的链接
            return Math.max(left, right) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}