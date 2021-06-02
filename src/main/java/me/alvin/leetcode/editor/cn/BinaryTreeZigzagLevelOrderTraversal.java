//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 449 👎 0


package me.alvin.leetcode.editor.cn;

import support.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (null == root) {
                return new ArrayList<>(0);
            }
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> level;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            int flag = 1;
            while (!q.isEmpty()) {
                int levelSize = q.size();
                level = new ArrayList<>(levelSize);
                //
                for (int i = 0; i < levelSize; i++) {
                    TreeNode current = q.poll();
                    if (flag % 2 == 1) {
                        level.add(current.val);
                    } else {
                        level.add(0, current.val);
                    }

                    if (null != current.left) {
                        q.offer(current.left);
                    }
                    if (null != current.right) {
                        q.offer(current.right);
                    }
                }
                result.add(level);
                flag++;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}