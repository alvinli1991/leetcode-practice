//给定一个字符串 s ，找出 至多 包含 k 个不同字符的最长子串 T。 
//
// 示例 1: 
//
// 输入: s = "eceba", k = 2
//输出: 3
//解释: 则 T 为 "ece"，所以长度为 3。 
//
// 示例 2: 
//
// 输入: s = "aa", k = 1
//输出: 2
//解释: 则 T 为 "aa"，所以长度为 2。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 130 👎 0


package me.alvin.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithAtMostKDistinctCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            int left = 0;
            int right = 0;
            int longest = 0;
            Map<Character, Integer> window = new HashMap<>();

            while (right < s.length()) {
                Character addChar = s.charAt(right);
                //下面两行代码可以用这行代替 window.put(addChar, window.getOrDefault(addChar, 0) + 1);
                window.computeIfPresent(addChar, (key, v) -> ++v);
                window.putIfAbsent(addChar, 1);
                right++;
                if (window.size() <= k) {
                    longest = Math.max(longest, right - left);
                }

                while (window.size() > k) {
                    Character removeChar = s.charAt(left);
                    window.computeIfPresent(removeChar, (key, v) -> --v);
                    if (window.get(removeChar) == 0) {
                        window.remove(removeChar);
                    }
                    left++;

                    if (window.size() <= k) {
                        longest = Math.max(longest, right - left);
                    }

                }
            }
            return longest;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}