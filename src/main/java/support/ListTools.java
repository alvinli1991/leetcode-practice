package support;

/**
 * @author Alvin Li
 * @since 2021/5/18 21:54
 */
public class ListTools {
    public static ListNode buildLinkedList(int[] nums) {
        ListNode first = new ListNode(nums[0]);
        ListNode last = first;
        for (int i = 1; i < nums.length; i++) {
            ListNode newNode = new ListNode(nums[i]);
            last.next = newNode;
            last = newNode;
        }
        return first;
    }

    public static ListNode buildLinkedList(int[] nums, ListNode node, int i) {
        if (i < nums.length) {
            node = new ListNode(nums[i]);
            node.next = buildLinkedList(nums, node.next, i + 1);
        }
        return node;
    }
}
