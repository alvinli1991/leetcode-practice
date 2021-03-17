//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1292 👎 0


package me.alvin.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2_l = new TreeNode(2);
        TreeNode node2_r = new TreeNode(2);
        TreeNode node3_l = new TreeNode(3);
        TreeNode node3_r = new TreeNode(3);
        TreeNode node4_l = new TreeNode(4);
        TreeNode node4_r = new TreeNode(4);
        node1.left = node2_l;
        node1.right = node2_r;
        node2_l.left = node3_l;
        node2_l.right = node4_r;
        node2_r.left = node4_l;
        node2_r.right = node3_r;
        System.out.println(solution.isSymmetric(node1));
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
        public boolean isSymmetric(TreeNode root) {
            if (null == root) {
                return true;
            }
            return checkSymmetric(root.left, root.right);
        }

        public boolean checkSymmetric(TreeNode left, TreeNode right) {
            if ((null == left && null != right) || (null != left && null == right)) {
                return false;
            } else if (null != left && null != right) {
                if (left.val == right.val) {
                    return checkSymmetric(left.left, right.right) && checkSymmetric(left.right, right.left);
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }

        public boolean check(TreeNode p, TreeNode q) {
            if (null == p && null == q) {
                return true;
            }
            if (null == p || null == q) {
                return false;
            }
            return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
        }

        public boolean checkWithQueue(TreeNode u, TreeNode v) {
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(u);
            q.offer(v);
            while (!q.isEmpty()) {
                u = q.poll();
                v = q.poll();
                if (u == null && v == null) {
                    continue;
                }
                if ((u == null || v == null) || (u.val != v.val)) {
                    return false;
                }
                q.offer(u.left);
                q.offer(v.right);
                q.offer(u.right);
                q.offer(v.left);
            }
            return true;
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