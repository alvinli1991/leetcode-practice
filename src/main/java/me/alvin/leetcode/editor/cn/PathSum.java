//给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和
// targetSum 。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// Related Topics 树 深度优先搜索 
// 👍 546 👎 0


package me.alvin.leetcode.editor.cn;

public class PathSum {
    public static void main(String[] args) {
        Solution solution = new PathSum().new Solution();
        TreeNode node5 = new TreeNode(5);
        TreeNode node4_l = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node11 = new TreeNode(11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node4_r = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        node5.left = node4_l;
        node5.right = node8;
        node4_l.left = node11;
        node11.left = node7;
        node11.right = node2;
        node8.left = node13;
        node8.right = node4_r;
        node4_r.right = node1;
        System.out.println(solution.hasPathSum(node5, 22));

        TreeNode node2_2 = new TreeNode(2);
        TreeNode node2_1 = new TreeNode(1);
        node2_1.right = node2_2;
        System.out.println(solution.hasPathSum(node2_1, 1));


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
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (null == root) {
                return false;
            }
            return hasPath(root, root.val, targetSum);
        }


        public boolean hasPath(TreeNode root, int acc, int targetSum) {
            if (root == null) {
                return false;
            }
            //如果此节点是叶子节点，则判断结果
            if (isLeafNode(root)) {
                return acc == targetSum;
            }

            //计算根节点的左叶节点的sum是否和targetSum一致
            TreeNode left = root.left;
            int leftSum = calculateSum(acc, left);

            if (null != left && isLeafNode(left)) {
                if (targetSum == leftSum) {
                    return true;
                }
            }


            //计算根节点的右节点的sum是否和targetSum一致
            TreeNode right = root.right;
            int rightSum = calculateSum(acc, right);

            if (null != right && isLeafNode(right)) {
                if (targetSum == rightSum) {
                    return true;
                }
            }

            //递归调用左右节点
            return hasPath(root.left, leftSum, targetSum) || hasPath(root.right, rightSum, targetSum);

        }

        boolean isLeafNode(TreeNode node) {
            return null != node &&  null == node.left && null == node.right;
        }

        int calculateSum(int acc, TreeNode node) {
            int sum = acc;
            if (null != node) {
                sum += node.val;
            }
            return sum;
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