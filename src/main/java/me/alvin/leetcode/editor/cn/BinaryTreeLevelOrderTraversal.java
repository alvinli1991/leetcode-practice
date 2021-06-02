//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 884 👎 0


package me.alvin.leetcode.editor.cn;

import support.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal{
      public static void main(String[] args) {
           Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(null == root){
            return new ArrayList<>(0);
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> level;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int levelSize = q.size();
            level = new ArrayList<>(levelSize);
            List<TreeNode> levelNodes = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = q.poll();
                levelNodes.add(current);
                level.add(current.val);
            }
            result.add(level);

            for (TreeNode node:levelNodes){
                if(null != node.left){
                    q.offer(node.left);
                }
                if(null != node.right){
                    q.offer(node.right);
                }
            }
        }
        return result;
    }

    /**
     * 与上面的相比，由于已经确定poll出的元素个数，可以直接往队列后面加而不需要另外存储
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if(null == root){
            return new ArrayList<>(0);
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> level;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int levelSize = q.size();
            level = new ArrayList<>(levelSize);
            //
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
            result.add(level);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }