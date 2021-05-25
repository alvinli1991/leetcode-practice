//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 474 👎 0


package me.alvin.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
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
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> paths = new LinkedList<>();
            String path = "";
            buildTreePath(root, paths, path);
            return paths;
        }


        public void buildTreePath(TreeNode node, List<String> paths, String path) {
            if (null == node) {
                return;
            }
            if ("".equals(path)) {
                path = String.valueOf(node.val);
            } else {
                path = path + "->" + node.val;
            }

            if (null == node.left && null == node.right) {
                paths.add(path);
            }

            buildTreePath(node.left, paths, path);
            buildTreePath(node.right, paths, path);
        }

        public void findPath(TreeNode root,StringBuilder path,List<String>result){
            if(null == root){
                return;
            }
            if(path.length() == 0){
                path.append(root.val);
            }else{
                path.append("->").append(root.val);
            }

            if(null == root.left && null == root.right){
                result.add(path.toString());
            }

            findPath(root.left,new StringBuilder(path),result);
            findPath(root.right,new StringBuilder(path),result);
        }

    }

    //leetcode submit region end(Prohibit modification and deletion)
    class Solution2 {
        public List<String> binaryTreePaths(TreeNode root) {
            List<List<Integer>> paths = new LinkedList<>();
            List<Integer> path = new LinkedList<>();
            buildTreePath(root, paths, path);
            return paths.stream()
                    .map(nodes -> nodes.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining("->")))
                    .collect(Collectors.toList());
        }


        public void buildTreePath(TreeNode node, List<List<Integer>> paths, List<Integer> path) {
            if (null == node) {
                return;
            }
            path.add(node.val);
            if (null == node.left && null == node.right) {
                paths.add(path);
            }

            if (null != node.left && null != node.right) {
                buildTreePath(node.left, paths, new LinkedList<>(path));
                buildTreePath(node.right, paths, new LinkedList<>(path));
            } else {
                if (null != node.left) {
                    buildTreePath(node.left, paths, path);
                }
                if (null != node.right) {
                    buildTreePath(node.right, paths, path);
                }
            }
        }

    }

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