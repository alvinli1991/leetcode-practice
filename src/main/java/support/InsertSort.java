package support;

/**
 * @author Alvin Li
 * @since 2021/5/31 11:04
 */
public class InsertSort {

    public static void sort(Comparable[] a) {
        int length = a.length;
        for (int i = 1; i < length; i++) {
            //将a[i] 插入到a[i-1],a[i-2]……中去
            for (int j = i; j > 0 && SortTemplate.less(a[j], a[j - 1]); j--) {
                SortTemplate.swap(a, j, j - 1);
            }
        }
    }
}
