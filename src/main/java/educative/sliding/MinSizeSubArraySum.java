package educative.sliding;

/**
 * @author Alvin Li
 * @since 2021/5/23 16:55
 */
public class MinSizeSubArraySum {
    public static void main(String[] args) {
        System.out.println(findMinSubArray2(7, new int[]{2, 1, 5, 2, 3, 2}));
        System.out.println(findMinSubArray2(7, new int[]{2, 1, 5, 2, 8}));
        System.out.println(findMinSubArray2(8, new int[]{3, 4, 1, 1, 6}));
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
}
