//给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
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
// 返回其自底向上的层序遍历为： 
//
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 441 👎 0


package me.alvin.leetcode.editor.cn;

import support.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversalIi{
      public static void main(String[] args) {
           Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(null == root){
            return new ArrayList<>(0);
        }
        Stack<List<Integer>> resultStack = new Stack<>();
        List<Integer> level;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int levelSize = q.size();
            level = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = q.poll();
                level.add(current.val);

                if(null != current.left){
                    q.offer(current.left);
                }
                if(null != current.right){
                    q.offer(current.right);
                }
            }
            resultStack.push(level);
        }
        List<List<Integer>> result = new ArrayList<>(resultStack.size());
        while(!resultStack.isEmpty()){
            result.add(resultStack.pop());
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }