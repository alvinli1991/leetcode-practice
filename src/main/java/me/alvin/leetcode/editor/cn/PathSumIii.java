//给定一个二叉树，它的每个结点都存放着一个整数值。 
//
// 找出路径和等于给定数值的路径总数。 
//
// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。 
//
// 示例： 
//
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//返回 3。和等于 8 的路径有:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
// 
// Related Topics 树 
// 👍 858 👎 0


package me.alvin.leetcode.editor.cn;

import support.TreeNode;
import support.TreeTools;

import java.util.HashMap;
import java.util.Map;

public class PathSumIii {
    public static void main(String[] args) {
        Solution solution = new PathSumIii().new Solution();
        TreeNode root = TreeTools.buildTree(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1}, 0);
        System.out.println(solution.pathSum(root, 8));
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
        int count = 0;

        public int pathSum(TreeNode root, int targetSum) {
            return preSumPath(root, targetSum);
        }

        private int preSumPath(TreeNode root, int targetSum) {
            Map<Integer, Integer> preSumCount = new HashMap<>();
            preSumCount.put(0, 1);
            return preSumDfs(root, targetSum, 0, preSumCount);
        }

        /**
         *
         * @param root 测试节点
         * @param target 目标数值
         * @param currentPathSum 当前路径前缀和
         * @param preSumCount 前缀和与个数的缓存
         * @return 返回符合条件的路径数
         */
        private int preSumDfs(TreeNode root, int target, int currentPathSum, Map<Integer, Integer> preSumCount) {
            if (null == root) {
                return 0;
            }
            int pathCount = 0;
            //计算当前的前缀和
            currentPathSum += root.val;
            //计算需要的前缀和，然后从缓存中寻找是否存在此前缀和
            int requiredPrePathSum = currentPathSum - target;
            pathCount += preSumCount.getOrDefault(requiredPrePathSum, 0);
            //存储当前的前缀和
            preSumCount.put(currentPathSum, preSumCount.getOrDefault(currentPathSum, 0) + 1);
            //遍历左右子路径
            pathCount += preSumDfs(root.left, target, currentPathSum, preSumCount);
            pathCount += preSumDfs(root.right, target, currentPathSum, preSumCount);
            //当遍历完该节点的左右子路径，需要将它从缓存中去除，因为在遍历其它分支时，该节点已经不存在
            preSumCount.computeIfPresent(currentPathSum, (k, v) -> --v);
            return pathCount;
        }

        //region 暴力解法

        /**
         * 此解法是dfs的暴力解法
         * 1. 它会以每个节点为顶点，来测试它与子路径节点的和是否为目标值。
         * 2. 在每一个节点处，它会以target-val的方式将测试传递下去
         *
         * @param node
         * @param target
         */
        private void dfs(TreeNode node, int target) {
            if (null == node) {
                return;
            }
            check(node, target);
            dfs(node.left, target);
            dfs(node.right, target);
        }

        /**
         * 使用dfs递归测试，以该节点为顶点的路径，是否有满足要求的
         *
         * @param node
         * @param target
         */
        private void check(TreeNode node, int target) {
            if (null == node) {
                return;
            }
            if (node.val == target) {
                count++;
            }
            check(node.left, target - node.val);
            check(node.right, target - node.val);
        }
        //endregion
    }
//leetcode submit region end(Prohibit modification and deletion)

}