//给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。 
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 
//
// 示例 1： 
//
// 
//输入：p = [1,2,3], q = [1,2,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：p = [1,2], q = [1,null,2]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：p = [1,2,1], q = [1,1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 两棵树上的节点数目都在范围 [0, 100] 内 
// -104 <= Node.val <= 104 
// 
// Related Topics 树 深度优先搜索 
// 👍 584 👎 0


package me.alvin.leetcode.editor.cn;

public class SameTree {
    public static void main(String[] args) {
        Solution solution = new SameTree().new Solution();
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
        public boolean isSameTree(TreeNode p, TreeNode q) {
            return travel(p).equals(travel(q));
        }

        /**
         * 使用前序遍历，序列化树然后再进行比较。
         * 此种做法需要额外的空间存储序列化结果，空间复杂度较高
         *
         * @param root
         * @return
         */
        public String travel(TreeNode root) {
            if (null == root) {
                return "null";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(root.val);
            String left = travel(root.left);
            String right = travel(root.right);
            sb.append(left);
            sb.append(right);
            return sb.toString();
        }

        /**
         * 和上面的解法来看也是递归，但是它不需要额外的空间，是就地比较
         *
         * @param p
         * @param q
         * @return
         */
        public boolean deepTravel(TreeNode p, TreeNode q) {
            if (null == p && null == q) {
                return true;
            } else if (null == p) {
                return false;
            } else if (null == q) {
                return false;
            } else if (p.val != q.val) {
                return false;
            } else {
                return deepTravel(p.left, q.left) && deepTravel(p.right, q.right);
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