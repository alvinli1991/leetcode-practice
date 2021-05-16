//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3646 👎 0


package me.alvin.leetcode.editor.cn;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.longestPalindrome("a"));
        System.out.println(solution.longestPalindrome("ac"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int length = s.length();
            int[][] dp = new int[length][length];
            for (int i = 0; i < length; i++) {
                dp[i][i] = 1;
                if (i < length - 1 && s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][i + 1] = 2;
                }
            }
            int maxLength = 1;
            int start = 0;
            int end = 0;
            for (int i = length - 2; i >= 0; i--) {
                for (int j = i + 1; j < length; j++) {
                    if (dp[i + 1][j - 1] > 0) {
                        if (s.charAt(i) == s.charAt(j)) {
                            dp[i][j] = dp[i + 1][j - 1] + 2;
                        }
                    }
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        start = i;
                        end = j;
                    }
                }
            }
            return s.substring(start, end + 1);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}