package educative.sliding;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 *
 * @author Alvin Li
 * @since 2021/5/23 21:22
 */
public class LongestSubstringKDistinct {

    public static void main(String[] args) {
        System.out.println(findLength("araaci", 2));
        System.out.println(findLength("araaci", 1));
        System.out.println(findLength("cbbebi", 3));

    }

    public static int findLength(String str, int k) {
        int left = 0;
        int right = 0;
        int longest = 0;
        Map<Character, Integer> window = new HashMap<>();

        while (right < str.length()) {
            Character addChar = str.charAt(right);
            //下面两行代码可以用这行代替 window.put(addChar, window.getOrDefault(addChar, 0) + 1);
            window.computeIfPresent(addChar, (key, v) -> ++v);
            window.putIfAbsent(addChar, 1);
            right++;
            if (window.size() <= k) {
                longest = Math.max(longest, right - left);
            }

            while (window.size() > k) {
                Character removeChar = str.charAt(left);
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
