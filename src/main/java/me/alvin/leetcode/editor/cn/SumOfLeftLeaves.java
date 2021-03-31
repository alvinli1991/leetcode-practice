//计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 
// 👍 298 👎 0


package me.alvin.leetcode.editor.cn;

public class SumOfLeftLeaves {
    public static void main(String[] args) {
        Solution solution = new SumOfLeftLeaves().new Solution();
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
        int sum = 0;

        public int sumOfLeftLeaves(TreeNode root) {
            if (null == root) {
                return 0;
            }

            TreeNode left = root.left;
            if (null != left && null == left.left && null == left.right) {
                sum += left.val;
            }

            sumOfLeftLeaves(root.left);
            sumOfLeftLeaves(root.right);
            return sum;
        }

        /**
         * 此方法相较于上面更好的使用了递归的性质
         * 1. 没有使用全局变量
         * 2. 利用递归函数的定义左叶子的和，来构造函数
         *
         * @param node
         * @return
         */
        public int travel(TreeNode node) {
            int sum = 0;
            if (null != node.left) {
                int leftSum = isLeafNode(node.left) ? node.left.val : travel(node.right);
                sum += leftSum;
            }

            if (null != node.right && !isLeafNode(node.right)) {
                int rightSum = travel(node.right);
                sum += rightSum;
            }
            return sum;
        }

        public boolean isLeafNode(TreeNode node) {
            return node.left == null && node.right == null;
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