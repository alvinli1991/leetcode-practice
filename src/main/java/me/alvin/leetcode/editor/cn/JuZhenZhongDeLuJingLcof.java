//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 深度优先搜索 
// 👍 336 👎 0


package me.alvin.leetcode.editor.cn;

public class JuZhenZhongDeLuJingLcof {
    public static void main(String[] args) {
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(solution.exist(board, "ABCCED"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] visited;
        int rows;
        int cols;

        public boolean exist(char[][] board, String word) {
            char[] words = word.toCharArray();

            rows = board.length;
            cols = board[0].length;
            visited = new boolean[rows][cols];
            //以每一个格子开头去遍历
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (dfs(board, i, j, words, 0)) {
                        return true;
                    }
                }

            }
            return false;
        }

        private boolean dfs(char[][] board, int row, int col, char[] words, int index) {
            /**
             * 剪枝
             */
            //如果下标越界
            if (row < 0 || row >= rows || col < 0 || col >= cols) {
                return false;
            }
            //被使用了
            if (visited[row][col]) {
                return false;
            }
            //不等
            if (board[row][col] != words[index]) {
                return false;
            }
            //当达到最后一个，且相等，则表示有一条路是的
            if (index == words.length-1) {
                return true;
            }

            /**
             * 回溯
             */
            //标记是否已被访问
            visited[row][col] = true;
            //上下左右
            boolean result = dfs(board, row - 1, col, words, index + 1) || dfs(board, row, col - 1, words, index + 1)
                    || dfs(board, row + 1, col, words, index + 1) || dfs(board, row, col + 1, words, index + 1);
            visited[row][col] = false;
            return result;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}