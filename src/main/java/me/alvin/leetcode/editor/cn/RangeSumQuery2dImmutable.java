//给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。 
//
// 
//上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。 
//
// 
//
// 示例： 
//
// 
//给定 matrix = [
//  [3, 0, 1, 4, 2],
//  [5, 6, 3, 2, 1],
//  [1, 2, 0, 1, 5],
//  [4, 1, 0, 1, 7],
//  [1, 0, 3, 0, 5]
//]
//
//sumRegion(2, 1, 4, 3) -> 8
//sumRegion(1, 1, 2, 2) -> 11
//sumRegion(1, 2, 2, 4) -> 12
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设矩阵不可变。 
// 会多次调用 sumRegion 方法。 
// 你可以假设 row1 ≤ row2 且 col1 ≤ col2 。 
// 
// Related Topics 动态规划 
// 👍 257 👎 0


package me.alvin.leetcode.editor.cn;

public class RangeSumQuery2dImmutable {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix obj = new RangeSumQuery2dImmutable().new NumMatrix(matrix);
        System.out.println(obj.sumRegion(2, 1, 4, 3));
        System.out.println(obj.sumRegion(1, 1, 2, 2));
        System.out.println(obj.sumRegion(1, 2, 2, 4));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumMatrix {

        /**
         * 二维前缀和：以(0,0) 、(row,col)为左上、右下顶点的矩形
         */
        int[][] preSum2Dim;

        public NumMatrix(int[][] matrix) {
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

    /**
     * Your NumMatrix object will be instantiated and called as such:
     * NumMatrix obj = new NumMatrix(matrix);
     * int param_1 = obj.sumRegion(row1,col1,row2,col2);
     */
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 求每一行的前缀和，然后遍历累加限定范围内的前缀和
     */
    class NumMatrix1Dim {
        /**
         * int[row] 表示第row行的前缀和
         */
        int[][] preSum1Dim;

        public NumMatrix1Dim(int[][] matrix) {
            int rowCount = matrix.length;
            if (rowCount > 0) {
                int colCount = matrix[0].length;
                preSum1Dim = new int[rowCount][colCount + 1];
                for (int row = 0; row < rowCount; row++) {
                    for (int col = 0; col < colCount; col++) {
                        preSum1Dim[row][col + 1] = preSum1Dim[row][col] + matrix[row][col];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int row = row1; row <= row2; row++) {
                sum += preSum1Dim[row][col2 + 1] - preSum1Dim[row][col1];
            }
            return sum;
        }
    }

}