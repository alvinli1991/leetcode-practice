package educative.sliding;

/**
 * @author Alvin Li
 * @since 2021/5/23 16:15
 */
public class MaxSumSubArrayOfSizeK {
    public static void main(String[] args) {
        System.out.println(findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2}));
        System.out.println(findMaxSumSubArray(2, new int[]{2, 3, 4, 1, 5}));
    }

    public static int findMaxSumSubArray(int k, int[] arr) {
        int left = 0;
        int right = 0;
        int max = 0;
        int windowSum = 0;
        int windowSize = 0;
        while (right < arr.length) {
            //移入窗口
            windowSum += arr[right];
            //窗口右移动
            right++;
            //窗口大小更新
            windowSize++;

            //收缩条件。此处是当窗口大小达到K时
            if (windowSize == k) {
                max = Math.max(max, windowSum);
                //移除窗口
                windowSum -= arr[left];
                //左移窗口
                left++;
                //窗口大小更新
                windowSize--;
            }
        }
        return max;
    }

    public static int findMaxSumSubArray2(int k, int[] arr) {
        int maxSum = 0;
        int windowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return maxSum;

    }
}
