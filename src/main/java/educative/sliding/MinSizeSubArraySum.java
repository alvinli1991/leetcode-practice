package educative.sliding;

/**
 * Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.
 * @author Alvin Li
 * @since 2021/5/23 16:55
 */
public class MinSizeSubArraySum {
    public static void main(String[] args) {
        System.out.println(findMinSubArray3(7, new int[]{2, 1, 5, 2, 3, 2}));
        System.out.println(findMinSubArray3(7, new int[]{2, 1, 5, 2, 8}));
        System.out.println(findMinSubArray3(8, new int[]{3, 4, 1, 1, 6}));
    }

    public static int findMinSubArray(int s, int[] arr) {
        int left = 0;
        int right = 0;
        int minWindowSize = 0;
        int windowSize = 0;
        int windowSum = 0;
        while (right < arr.length) {
            windowSum += arr[right];
            right++;
            windowSize++;

            while (windowSum >= s) {
                if (minWindowSize == 0) {
                    minWindowSize = windowSize;
                } else {
                    minWindowSize = Math.min(minWindowSize, windowSize);
                }
                windowSum -= arr[left];
                left++;
                windowSize--;
            }
        }
        return minWindowSize;
    }

    /**
     * 使用最大值设置窗口最大边界
     *
     * @param s
     * @param arr
     * @return
     */
    public static int findMinSubArray2(int s, int[] arr) {
        int left = 0;
        int right = 0;
        int minWindowSize = Integer.MAX_VALUE;
        int windowSize = 0;
        int windowSum = 0;
        while (right < arr.length) {
            windowSum += arr[right];
            right++;
            windowSize++;

            while (windowSum >= s) {
                minWindowSize = Math.min(minWindowSize, windowSize);
                windowSum -= arr[left];
                left++;
                windowSize--;
            }
        }
        return minWindowSize == Integer.MAX_VALUE ? 0 : minWindowSize;
    }

    /**
     * 去掉windowsSize变量，使用right，left来计算
     *
     * @param s
     * @param arr
     * @return
     */
    public static int findMinSubArray3(int s, int[] arr) {
        int left = 0;
        int right = 0;
        int minWindowSize = Integer.MAX_VALUE;
        int windowSum = 0;
        while (right < arr.length) {
            windowSum += arr[right];
            right++;

            while (windowSum >= s) {
                minWindowSize = Math.min(minWindowSize, right - left);
                windowSum -= arr[left];
                left++;
            }
        }
        return minWindowSize == Integer.MAX_VALUE ? 0 : minWindowSize;
    }
}
