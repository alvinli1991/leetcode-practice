//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 输入的字符串长度不会超过 1000 。 
// 
// Related Topics 字符串 动态规划 
// 👍 576 👎 0


package me.alvin.leetcode.editor.cn;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        Solution solution = new PalindromicSubstrings().new Solution();
        System.out.println(solution.countSubstrings("abc"));
        System.out.println(solution.countSubstrings("aaa"));
        System.out.println(solution.countSubstrings("bbbab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            int length = s.length();
            if (length > 1000) {
                return 0;
            }
            int[][] dp = new int[length][length];

            int result = 0;

            for (int i = 0; i < length; i++) {
                dp[i][i] = 1;
                result++;
                if (i < length - 1 && s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][i + 1] = 2;
                    result++;
                }
            }
            for (int i = length - 2; i >= 0; i--) {
                for (int j = i + 1; j < length; j++) {
                    if (dp[i + 1][j - 1] > 0) {
                        if (s.charAt(i) == s.charAt(j)) {
                            dp[i][j] = dp[i + 1][j - 1] + 2;
                        }
                    }
                    if (dp[i][j] > 2) {
                        result++;
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}