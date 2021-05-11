package support;


import me.alvin.leetcode.editor.cn.TreeNode;

/**
 * @author Alvin Li
 * @since 2021/5/10 11:10
 */
public class TreeTools {
    public static TreeNode buildTree(Integer[] nodes, TreeNode root, int i) {
        if (i < nodes.length) {
            if(nodes[i] != null){
                root = new TreeNode(nodes[i]);
                root.left = buildTree(nodes, root.left, 2 * i + 1);
                root.right = buildTree(nodes, root.right, 2 * (i + 1));
            }
        }
        return root;
    }
}
