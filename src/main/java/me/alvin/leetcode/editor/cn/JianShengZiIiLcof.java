//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1]
// 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘
//积是18。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
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
// 
//
// 提示： 
//
// 
// 2 <= n <= 1000 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// Related Topics 数学 动态规划 
// 👍 116 👎 0


package me.alvin.leetcode.editor.cn;

import java.math.BigInteger;

public class JianShengZiIiLcof {
    public static void main(String[] args) {
        Solution solution = new JianShengZiIiLcof().new Solution();
        System.out.println(solution.cuttingRope(10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int cuttingRope(int n) {
            BigInteger[] dp = new BigInteger[n + 1];
            dp[0]=BigInteger.ZERO;
            dp[1]=BigInteger.ZERO;
            for (int i = 2; i <= n; i++) {
                BigInteger thisMax = BigInteger.ZERO;
                for (int j = 1; j <= i / 2; j++) {
                    thisMax = thisMax.max(BigInteger.valueOf((long) j * (i - j))).max(dp[i - j].multiply(BigInteger.valueOf(j)));
                }
                dp[i] = thisMax;
            }
            return dp[n].mod(BigInteger.valueOf(1000000007)).intValue();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}