//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1709 👎 0


package me.alvin.leetcode.editor.cn;

import support.ListNode;
import support.ListTools;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        ListNode l1 = ListTools.buildLinkedList(new int[]{1,2,3});
        ListNode l2 = ListTools.buildLinkedList(new int[]{1,3,4});
        ListNode merge = solution.mergeTwoLists2(l1, l2);
        System.out.println(merge);
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummyNode = new ListNode(-1);
            ListNode tail = dummyNode;
            ListNode node1 = l1;
            ListNode node2 = l2;

            while (node1 != null && node2 != null) {
                if (node1.val < node2.val) {
                    tail.next = node1;
                    node1 = node1.next;

                    tail = tail.next;
                } else if (node1.val > node2.val) {
                    tail.next = node2;
                    node2 = node2.next;

                    tail = tail.next;
                } else {
                    tail.next = node1;
                    node1 = node1.next;
                    tail.next.next = node2;
                    node2 = node2.next;

                    tail = tail.next.next;
                }

            }

            if (node1 == null) {
                tail.next = node2;
            }

            if (node2 == null) {
                tail.next = node1;
            }
            return dummyNode.next;
        }

        /**
         * 与上面一个不同点在于，把相等的情况归到某一个中，这样tail指针的移动可以统一
         * @param l1
         * @param l2
         * @return
         */
        public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
            ListNode dummyNode = new ListNode(-1);
            ListNode tail = dummyNode;
            ListNode node1 = l1;
            ListNode node2 = l2;

            while (node1 != null && node2 != null) {
                if (node1.val < node2.val) {
                    tail.next = node1;
                    node1 = node1.next;
                } else {
                    tail.next = node2;
                    node2 = node2.next;
                }
                tail = tail.next;
            }

            if (node1 == null) {
                tail.next = node2;
            }

            if (node2 == null) {
                tail.next = node1;
            }
            return dummyNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}