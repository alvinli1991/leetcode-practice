//给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
// 
//
// 注意：字符串长度 和 k 不会超过 104。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ABAB", k = 2
//输出：4
//解释：用两个'A'替换为两个'B',反之亦然。
// 
//
// 示例 2： 
//
// 
//输入：s = "AABABBA", k = 1
//输出：4
//解释：
//将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
//子串 "BBBB" 有最长重复字母, 答案为 4。
// 
// Related Topics 双指针 Sliding Window 
// 👍 444 👎 0


package me.alvin.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        Solution solution = new LongestRepeatingCharacterReplacement().new Solution();
        System.out.println(solution.characterReplacement("ABAB",2));//4
        System.out.println(solution.characterReplacement("AABABBA",1));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int characterReplacement(String s, int k) {
            int left = 0;
            int right = 0;
            //记录当前区间内，最多字符的个数
            int maxCount = 0;
            Map<Character, Integer> letterCount = new HashMap<>(26);

            int maxLength = 0;
            while (right < s.length()) {
                char addChar = s.charAt(right);
                letterCount.put(addChar, letterCount.getOrDefault(addChar, 0) + 1);
                maxCount = Math.max(maxCount, letterCount.get(addChar));
                right++;

                //直到剩下的字符已不能经过k次替换全变成最多的字符
                while (right - left > k + maxCount) {
                    char removeChar = s.charAt(left);
                    letterCount.computeIfPresent(removeChar, (key, v) -> --v);
                    left++;
                }
                //此时right-left == k + maxCount
                maxLength = Math.max(maxLength, right - left);
            }

            return maxLength;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}