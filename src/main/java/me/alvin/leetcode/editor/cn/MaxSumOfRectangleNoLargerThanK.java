//给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。 
//
// 题目数据保证总会存在一个数值和不超过 k 的矩形区域。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,0,1],[0,-2,3]], k = 2
//输出：2
//解释：蓝色边框圈出来的矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[2,2,-1]], k = 3
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -100 <= matrix[i][j] <= 100 
// -105 <= k <= 105 
// 
//
// 
//
// 进阶：如果行数远大于列数，该如何设计解决方案？ 
// Related Topics 队列 二分查找 动态规划 
// 👍 293 👎 0


package me.alvin.leetcode.editor.cn;

public class MaxSumOfRectangleNoLargerThanK {
    public static void main(String[] args) {
        Solution solution = new MaxSumOfRectangleNoLargerThanK().new Solution();
//        System.out.println(solution.maxSumSubmatrix(new int[][]{{1,0,1},{0,-2,3}},2));
//        System.out.println(solution.maxSumSubmatrix(new int[][]{{2,2,-1}},3));
        System.out.println(solution.maxSumSubmatrix(new int[][]{{2,2,-1}},0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSumSubmatrix(int[][] matrix, int k) {
            PreSumMatrix preSumMatrix = new PreSumMatrix(matrix);
            int rowCount = matrix.length;
            int colCount = matrix[0].length;
            int max = Integer.MIN_VALUE;
            for (int row1 = 0; row1 < rowCount; row1++) {
                for (int col1 = 0; col1 < colCount; col1++) {
                    for (int row2 = row1; row2 < rowCount; row2++) {
                        for (int col2 = row2; col2 < colCount; col2++) {
                            int matrixSum = preSumMatrix.sumRegion(row1, col1, row2, col2);
                            if (matrixSum <= k && matrixSum > max) {
                                max = Math.max(max, matrixSum);
                            }
                        }
                    }
                }
            }
            return max;
        }
    }

    class PreSumMatrix {

        /**
         * 二维前缀和：以(0,0) 、(row,col)为左上、右下顶点的矩形
         */
        int[][] preSum2Dim;

        public PreSumMatrix(int[][] matrix) {
            int rowCount = matrix.length;
            if (rowCount > 0) {
                int colCount = matrix[0].length;
                preSum2Dim = new int[rowCount + 1][colCount + 1];
                for (int row = 0; row < rowCount; row++) {
                    for (int col = 0; col < colCount; col++) {
                        preSum2Dim[row + 1][col + 1] = preSum2Dim[row][col + 1] + preSum2Dim[row + 1][col]
                                - preSum2Dim[row][col] + matrix[row][col];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preSum2Dim[row2 + 1][col2 + 1] - preSum2Dim[row1][col2 + 1] - preSum2Dim[row2 + 1][col1] + preSum2Dim[row1][col1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}