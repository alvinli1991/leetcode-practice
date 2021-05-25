//给定一个二叉树，我们称从根节点到任意叶节点的任意路径中的节点值所构成的序列为该二叉树的一个 “有效序列” 。检查一个给定的序列是否是给定二叉树的一个 “有效
//序列” 。 
//
// 我们以整数数组 arr 的形式给出这个序列。从根节点到任意叶节点的任意路径中的节点值所构成的序列都是这个二叉树的 “有效序列” 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
//输出：true
//解释：
//路径 0 -> 1 -> 0 -> 1 是一个“有效序列”（图中的绿色节点）。
//其他的“有效序列”是：
//0 -> 1 -> 1 -> 0 
//0 -> 0 -> 0
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
//输出：false 
//解释：路径 0 -> 0 -> 1 不存在，所以这不是一个“序列”。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
//输出：false
//解释：路径 0 -> 1 -> 1 是一个序列，但不是一个“有效序列”（译者注：因为序列的终点不是叶节点）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 5000 
// 0 <= arr[i] <= 9 
// 每个节点的值的取值范围是 [0 - 9] 
// 
// Related Topics 树 
// 👍 7 👎 0


package me.alvin.leetcode.editor.cn;

import support.TreeNode;
import support.TreeTools;

public class CheckIfAStringIsAValidSequenceFromRootToLeavesPathInABinaryTree {
    public static void main(String[] args) {
        Solution solution = new CheckIfAStringIsAValidSequenceFromRootToLeavesPathInABinaryTree().new Solution();
        System.out.println(solution.isValidSequence(TreeTools.buildTree(new Integer[]{0, 1, 0, 0, 1, 0, null, null, 1, 0, 0}, 0)
                , new int[]{0, 1, 0, 1}));
        System.out.println(solution.isValidSequence(TreeTools.buildTree(new Integer[]{0, 1, 0, 0, 1, 0, null, null, 1, 0, 0}, 0)
                , new int[]{0, 0, 1}));
        System.out.println(solution.isValidSequence(TreeTools.buildTree(new Integer[]{0, 1, 0, 0, 1, 0, null, null, 1, 0, 0}, 0)
                , new int[]{0, 1, 1}));
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
        public boolean isValidSequence(TreeNode root, int[] arr) {
            return dfs(root, arr, 0);
        }

        public boolean dfs(TreeNode root, int[] arr, int index) {
            //节点为空
            if (null == root) {
                return false;
            }
            //索引超过了数组下标；节点值不相等
            if (index > arr.length - 1 || root.val != arr[index]) {
                return false;
            }
            //节点值相等；序列到最后一个；是叶子节点
            if (index == arr.length - 1 && null == root.left && null == root.right) {
                return true;
            }
            index++;
            return dfs(root.left, arr, index) || dfs(root.right, arr, index);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}