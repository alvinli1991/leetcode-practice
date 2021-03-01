//翻转一棵二叉树。 
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树 
// 👍 774 👎 0


package me.alvin.leetcode.editor.cn;

import javax.swing.tree.TreeNode;

public class InvertBinaryTree {
    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree().new Solution();
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
        /**
         * 前序遍历
         * 1. 遇到节点先交换其左右子节点
         * 2. 再依次对它的左右节点进行操作
         * <p>
         * 形象来说，是自顶向下的反转
         *
         * @param root
         * @return
         */
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            invertTree(root.left);
            invertTree(root.right);

            return root;
        }

        /**
         * 后序遍历
         * 1. 先分别对左右子节点进行交换
         * 2. 最后交换根节点的左右子节点
         * <p>
         * 形象来说，是自底向上的反转
         *
         * @param root
         * @return
         */
        public TreeNode invertTree2(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            //后续遍历
            root.left = right;
            root.right = left;

            return root;
        }

        /**
         * 错误解法:这样相当于左子树翻转了两次
         *
         * @param root
         * @return
         */
        public TreeNode wrongInvertTree3(TreeNode root) {
            if (root == null) {
                return null;
            }

            invertTree(root.left);

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            invertTree(root.right);

            return root;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public class TreeNode {
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