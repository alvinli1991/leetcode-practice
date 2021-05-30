package support;

import java.util.Arrays;

/**
 * @author Alvin Li
 * @since 2021/5/30 16:19
 */
public class Heap {
    public static void main(String[] args) {
        int[] data = new int[]{2, 8, 3, 1, 6, 5, 9};
        buildHeap(data);
        System.out.println(Arrays.toString(data));
    }

    public static void buildHeap(int[] data) {
        int length = data.length;
        /**
         * 最后一个非叶子节点 length / 2 - 1
         */
        for (int i = length / 2 - 1; i >= 0; i--) {
            maxHeapify(data, length, i);
        }
    }

    /**
     * 比较根节点和左右子树，并把最大的值转换到根节点上
     *
     * @param heap
     * @param heapSize
     * @param i
     */
    private static void maxHeapify(int[] heap, int heapSize, int i) {
        int l = left(i);
        int r = right(i);
        int largest;
        if (l <= heapSize && heap[l] > heap[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r <= heapSize && heap[r] > heap[largest]) {
            largest = r;
        }
        if (largest != i) {
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;
            maxHeapify(heap, heapSize, largest);
        }
    }

    private static int parent(int i) {
        return (i-1) / 2;
    }

    private static int left(int i) {
        return 2 * i + 1;
    }

    private static int right(int i) {
        return 2 * i + 2;
    }
}
