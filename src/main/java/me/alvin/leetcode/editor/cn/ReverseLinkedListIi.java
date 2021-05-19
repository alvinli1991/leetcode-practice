//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
// Related Topics 链表 
// 👍 906 👎 0


package me.alvin.leetcode.editor.cn;

import support.ListNode;
import support.ListTools;

public class ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
        ListNode head = ListTools.buildLinkedList(new int[]{1, 2, 3, 4, 5});
        System.out.println(solution.reverseBetweenByHeadInsert(head, 2, 4));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {

        /**
         * 递归算法
         *
         * @param head
         * @param left
         * @param right
         * @return
         */
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (left == 1) {
                return reversN(head, right);
            }
            head.next = reverseBetween(head.next, left - 1, right - 1);
            return head;
        }

        ListNode successor;

        public ListNode reversN(ListNode head, int n) {
            if (1 == n) {
                successor = head.next;
                return head;
            }
            ListNode last = reversN(head.next, n - 1);
            head.next.next = head;
            head.next = successor;
            return last;
        }

        /**
         * 前插法
         *
         * @param head
         * @param left
         * @param right
         * @return
         */
        public ListNode reverseBetweenByHeadInsert(ListNode head, int left, int right) {
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;

            //找到需要翻转的前一个节点，以及需要翻转区间的第一个节点
            ListNode guard = dummyHead;
            ListNode last = dummyHead.next;
            for (int i = 0; i < left - 1; i++) {
                guard = guard.next;
                last = last.next;
            }

            //例如是操作区间是[2,4]，那么需要操作节点是node3,node4，及两次
            for (int i = 0; i < right - left; i++) {
                ListNode remove = last.next;

                last.next = remove.next;
                remove.next = guard.next;
                guard.next = remove;
            }

            return dummyHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}