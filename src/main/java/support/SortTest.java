package support;

/**
 * @author Alvin Li
 * @since 2021/5/31 11:18
 */
public class SortTest {
    public static void main(String[] args) {
//        Integer[] a = new Integer[]{6,4,5,2,1,3};
//        QuickSort.sort(a);
//        SortTemplate.show(a);

        String[] b = new String[]{"K","R","A","T","E","L","E","P","U","I","M","Q","C","X","O","S"};
        QuickSort.sort(b);
        SortTemplate.show(b);

    }
}
