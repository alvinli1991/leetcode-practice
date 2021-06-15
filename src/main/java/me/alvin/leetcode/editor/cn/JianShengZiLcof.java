//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
//请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
//。 
//
// 示例 1： 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36 
//
// 提示： 
//
// 
// 2 <= n <= 58 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// Related Topics 数学 动态规划 
// 👍 248 👎 0


package me.alvin.leetcode.editor.cn;

public class JianShengZiLcof {
    public static void main(String[] args) {
        Solution solution = new JianShengZiLcof().new Solution();
        System.out.println(solution.cuttingRope(10));
        System.out.println(solution.dynamic(10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 此种方法没有完成的动态规划，动态规划数组排除了前3个.
         * f(n) = max{f(x)*f(n-x) | 0<x<n}
         * 当进行dp数组递推时，当剩下的绳子长度为1，2，3时，不剪断才能使乘积最大
         *
         * @param n
         * @return
         */
        public int cuttingRope(int n) {
            /**
             * 基本情况
             */
            if (n < 2) {
                return 0;
            }
            if (n == 2) {
                return 1;
            }
            if (n == 3) {
                return 2;
            }

            /**
             * 拆分的情况
             * 为1，2，3时，不拆后乘积是最大的
             */
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 3;
            int max = 0;
            for (int i = 4; i <= n; i++) {
                for (int j = 1; j <= i / 2; j++) {
                    int mul = dp[j] * dp[i - j];
                    if (mul > max) {
                        max = mul;
                    }
                    dp[i] = max;
                }
            }
            return dp[n];
        }

        /**
         * dp[n] 表示将长度为i的差分成至少两个正整数的和之后，这些正整数的最大乘积
         * <p>
         * 当i<2时，dp[0] = dp[1] = 0
         * 当i>2时，假设拆出了一个j(1<=j<i)，
         * i-j不再拆分，则乘积为j*(i-j)
         * i-j可以再拆分，则乘积为 j*dp[i-j]
         *
         * @param n
         * @return
         */
        public int dynamic(int n) {
            int[] dp = new int[n + 1];
            for (int i = 2; i <= n; i++) {
                int thisMax = 0;
                for (int j = 1; j <= i/2; j++) {
                    thisMax = Math.max(thisMax, Math.max(j * (i - j), j * dp[i - j]));
                }
                dp[i] = thisMax;
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}