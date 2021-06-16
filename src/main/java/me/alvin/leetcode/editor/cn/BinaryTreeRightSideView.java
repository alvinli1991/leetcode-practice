//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索 递归 队列 
// 👍 479 👎 0


package me.alvin.leetcode.editor.cn;

import support.TreeNode;
import support.TreeTools;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeRightSideView().new Solution();
        TreeNode root = TreeTools.buildTree(new Integer[]{1, 2, 3, null, 5, null, 4});
        System.out.println(solution.rightSideView(root));
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
         * 使用广度遍历，每次先将
         *
         * @param root
         * @return
         */
        public List<Integer> rightSideView(TreeNode root) {
            if (null == root) {
                return new ArrayList<>();
            }
            List<Integer> result = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    if (i == 0) {
                        result.add(node.val);
                    }
                    if (null != node.right) {
                        q.offer(node.right);
                    }
                    if (null != node.left) {
                        q.offer(node.left);
                    }

                }
            }
            return result;
        }


        public List<Integer> rightSideViewDFS(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            dfs(root, res, 0);
            return res;
        }

        public void dfs(TreeNode root, List<Integer> result, int depth) {
            if (null == root) {
                return;
            }

            /**
             * 先访问当前节点，在遍历右子树和左子树
             * 由于每层只会有一个元素加进去，所以深度和已有的结果个数不匹配，那么意味着这个节点是第一个被访问到的，加入即可
             * 例如一开始depth是0，结果列表中也是0，那么
             */
            if (depth == result.size()) {
                result.add(root.val);
            }

            depth++;
            dfs(root.right, result, depth);
            dfs(root.left, result, depth);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}