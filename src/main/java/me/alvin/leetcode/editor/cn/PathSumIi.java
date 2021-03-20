//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// 
// 
// Related Topics 树 深度优先搜索 
// 👍 443 👎 0


package me.alvin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PathSumIi {
    public static void main(String[] args) {
        Solution solution = new PathSumIi().new Solution();
        TreeNode node5 = new TreeNode(5);
        TreeNode node4_l = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node11 = new TreeNode(11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node4_r = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5_r = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        node5.left = node4_l;
        node5.right = node8;
        node4_l.left = node11;
        node11.left = node7;
        node11.right = node2;
        node8.left = node13;
        node8.right = node4_r;
        node4_r.left = node5_r;
        node4_r.right = node1;
        System.out.println(solution.pathSum(node5, 22));

        TreeNode node2_2 = new TreeNode(2);
        TreeNode node2_1 = new TreeNode(1);
        node2_1.right = node2_2;
        System.out.println(solution.pathSum(node2_1, 1));
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
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> result = new ArrayList<>();
            hasPathSumCheck(root, targetSum, result, null);
            return result;
        }

        public void hasPathSumCheck(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> path) {
            if (root == null) {
                return;
            }
            if (path == null) {
                path = new ArrayList<>();
            }

            path.add(root.val);
            if (null == root.left && null == root.right && targetSum == root.val) {
                result.add(path);
            }

            hasPathSumCheck(root.left, targetSum - root.val, result, new ArrayList<>(path));
            hasPathSumCheck(root.right, targetSum - root.val, result, new ArrayList<>(path));

//            if(isHasTwoChildren(root)){
//                hasPathSumCheck(root.left, targetSum - root.val, result, new ArrayList<>(path));
//                hasPathSumCheck(root.right, targetSum - root.val, result, new ArrayList<>(path));
//            }else{
//                if(null != root.left){
//                    hasPathSumCheck(root.left, targetSum - root.val, result, path);
//                }else if(null != root.right){
//                    hasPathSumCheck(root.right, targetSum - root.val, result, path);
//                }
//            }
        }


        public boolean isHasTwoChildren(TreeNode node){
            return null != node && node.left != null && node.right != null;
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