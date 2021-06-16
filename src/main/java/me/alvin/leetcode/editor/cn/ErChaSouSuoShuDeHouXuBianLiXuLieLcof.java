//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// 👍 279 👎 0


package me.alvin.leetcode.editor.cn;

public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
        System.out.println(solution.verifyPostorder(new int[]{1,3,2,7,6,5}));
        System.out.println(solution.verifyPostorder(new int[]{1,2,5,10,6,9,4,3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            return travese(postorder, 0, postorder.length - 1);
        }

        private boolean travese(int[] postorder, int start, int end) {
            //只有一个节点
            if (start >= end) {
                return true;
            }
            //找到第一个大于根的节点,则找到左子树区间[start,mark-1]
            int point = start;
            while (postorder[point] < postorder[end]) {
                point++;
            }
            int mark = point;
            //判断右子树区间[mark,end-1]是否都大与postOrder[end]
            boolean result = true;
            for (int i = mark; i < end; i++) {
                if (postorder[i] < postorder[end]) {
                    result = false;
                    break;
                }
            }
            return result && travese(postorder, start, mark - 1) && travese(postorder, mark, end - 1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}