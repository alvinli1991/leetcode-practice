package support;

/**
 * @author Alvin Li
 * @since 2021/5/31 11:24
 */
public class MergeSortTopBottom {

    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        //空间一次性分配
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    //内合并，使用辅助数组
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        //归并a[lo..mid],a[mid+1..hi]
        int i = lo, j = mid + 1;

        //将a[lo..hi]复制到aux[lo..hi]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        //归并到a[lo..hi]
        for (int k = lo; k <=hi ; k++) {
            if(i>mid){//左半边用尽(取右半边元素)
                a[k] = aux[j++];
            }else if(j>hi){//右半边用尽(取左半边元素)
                a[k] = aux[i++];
            }else if(SortTemplate.less(aux[j],aux[i])){//右半边当前元素小于左半边当前元素，取右半边的元素
                a[k] = aux[j++];
            }else{//右半边当前元素大于等于左边的当前元素，取左半边的元素
                a[k] = aux[i++];
            }
        }
    }
}
