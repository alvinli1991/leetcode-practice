package support;

/**
 * @author Alvin Li
 * @since 2021/5/31 12:00
 */
public class QuickSort {
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        //将数组切分为a[lo..i-1], a[i], a[i+1..hi]
        int i = lo;
        int j = hi + 1;//左右扫描指针
        Comparable v = a[lo];
        //扫描左右，检查扫描是否简述并交换元素
        while (true) {
            //从左往右扫描，知道找到一个比v大的或者到最后一个
            while (SortTemplate.less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            //从右往左扫描，直到找到一个比v小的或者到第一个
            while (SortTemplate.less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            //如果左右指针相遇时，退出循环
            if (i >= j) {
                break;
            }
            //如果他们没有相遇，则交换他们，保证左边的比v小，右边的比v大
            SortTemplate.swap(a, i, j);
        }
        //将v = a[j]放入正确的位置
        SortTemplate.swap(a, lo, j);
        //达成a[lo..j-1] <= a[j] <= a[j+1..hi]
        return j;
    }

}
