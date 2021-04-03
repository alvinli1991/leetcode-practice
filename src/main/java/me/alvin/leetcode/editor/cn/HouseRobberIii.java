//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“
//房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。 
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。 
//
// 示例 1: 
//
// 输入: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \ 
//     3   1
//
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7. 
//
// 示例 2: 
//
// 输入: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \ 
// 1   3   1
//
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
// 
// Related Topics 树 深度优先搜索 动态规划 
// 👍 791 👎 0


package me.alvin.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIii {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIii().new Solution();

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
    public class Solution {
        public static final int SELECTED = 0;
        public static final int NOT_SELECTED = 1;

        public int rob(TreeNode root) {
            int[] rootChoiceResult = robSub(root);
            return Math.max(rootChoiceResult[0], rootChoiceResult[1]);
        }

        private int[] robSub(TreeNode node) {
            if (node == null) return new int[]{0,0};

            int[] left = robSub(node.left);
            int[] right = robSub(node.right);

            int selected = node.val + left[NOT_SELECTED] + right[NOT_SELECTED];
            int notSelected = Math.max(left[SELECTED], left[NOT_SELECTED]) + Math.max(right[SELECTED], right[NOT_SELECTED]);

            return new int[]{selected, notSelected};
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

    //region 一种解法
    public class Solution1 {
        Map<TreeNode, Integer> chooseNode = new HashMap<>();
        Map<TreeNode, Integer> notChooseNode = new HashMap<>();

        public int rob(TreeNode root) {
            travel(root);
            return Math.max(chooseNode.getOrDefault(root, 0), notChooseNode.getOrDefault(root, 0));
        }

        public void travel(TreeNode node) {
            if (null == node) {
                return;
            }
            travel(node.left);
            travel(node.right);
            chooseNode.put(node, node.val + notChooseNode.getOrDefault(node.left, 0) + notChooseNode.getOrDefault(node.right, 0));
            notChooseNode.put(node, Math.max(chooseNode.getOrDefault(node.left, 0), notChooseNode.getOrDefault(node.left, 0))
                    + Math.max(chooseNode.getOrDefault(node.right, 0), notChooseNode.getOrDefault(node.right, 0)));
        }
    }
    //endregion

    //region 错误做法
    int maxValue;

    /**
     * 此种算法并没有穷举所有可能，仅仅考虑到了隔一个跳一个的情况，但实际情况是可以连着几个都不选
     *
     * @param node
     * @param useNode
     * @return
     */
    public int maxLeapPathSum2(TreeNode node, boolean useNode) {
        if (null == node) return 0;

        if (useNode) {
            int left = Math.max(0, maxLeapPathSum2(node.left, false));
            int right = Math.max(0, maxLeapPathSum2(node.right, false));
            maxValue = Math.max(maxValue, node.val + left + right);
            return node.val;
        } else {
            int left = Math.max(0, maxLeapPathSum2(node.left, true));
            int right = Math.max(0, maxLeapPathSum2(node.right, true));
            maxValue = Math.max(maxValue, left + right);
            return left + right;
        }
    }

    //endregion
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

