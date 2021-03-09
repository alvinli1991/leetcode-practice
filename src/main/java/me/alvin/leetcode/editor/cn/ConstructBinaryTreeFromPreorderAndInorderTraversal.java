//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 917 👎 0


package me.alvin.leetcode.editor.cn;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        int[] preorder = new int[]{1, 2, 5, 4, 6, 7, 3, 8, 9};
        int[] inorder = new int[]{5, 2, 6, 4, 7, 1, 8, 3, 9};
        TreeNode root = solution.buildTree(preorder, inorder);
        System.out.println(root);
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
            //当只有一个节点时，计算它前序节点数组的起始时，会出现此种情况
            if (preStart > preEnd) {
                return null;
            }
            //root节点的值为前序遍历数组的第一个值
            int rootValue = preorder[preStart];
            //rootValue在中序遍历的索引
            int inIndex = 0;
            for (int i = inStart; i <= inEnd; i++) {
                if (inorder[i] == rootValue) {
                    inIndex = i;
                    break;
                }
            }

            TreeNode root = new TreeNode(rootValue);
            root.left = build(preorder, preStart + 1, preStart + (inIndex - inStart), inorder, inStart, inIndex - 1);
            root.right = build(preorder, preStart + (inIndex - inStart) + 1, preEnd, inorder, inIndex + 1, inEnd);
            return root;
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