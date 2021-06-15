//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// 👍 298 👎 0


package me.alvin.leetcode.editor.cn;

public class JiQiRenDeYunDongFanWeiLcof {
    public static void main(String[] args) {
        Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();
        System.out.println(solution.movingCount(2,3,1));
        System.out.println(solution.movingCount(3,1,0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean visited[][];
        int count ;

        public int movingCount(int m, int n, int k) {
            count = 0;
            visited = new boolean[m][n];
            dfs(m, n, 0, 0, k);
            return count;
        }

        public void dfs(int rows, int cols, int row, int col, int k) {
            //越界的不要
            if (row < 0 || row >= rows || col < 0 || col >= cols) {
                return;
            }
            //被使用过的不要
            if (visited[row][col]) {
                return;
            }
            //不符合和的不要
            if (sum(row) + sum(col) > k) {
                return;
            }

            visited[row][col] = true;
            count++;

            /**
             * 由于从(0,0)开始，所以只可能是向下或者向右走
             */
            //向下走
            dfs(rows, cols, row + 1, col, k);
            //向右走
            dfs(rows, cols, row, col + 1, k);

        }

        public int sum(int row) {
            int amount = 0;
            while(row !=0){
                amount += row % 10;
                row = row / 10;
            }
            return amount;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}