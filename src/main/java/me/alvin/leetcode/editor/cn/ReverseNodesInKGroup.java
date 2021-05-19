//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 进阶： 
//
// 
// 你可以设计一个只使用常数额外空间的算法来解决此问题吗？ 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2,3,4,5], k = 1
//输出：[1,2,3,4,5]
// 
//
// 示例 4： 
//
// 
//输入：head = [1], k = 1
//输出：[1]
// 
//
// 
// 
//
// 提示： 
//
// 
// 列表中节点的数量在范围 sz 内 
// 1 <= sz <= 5000 
// 0 <= Node.val <= 1000 
// 1 <= k <= sz 
// 
// Related Topics 链表 
// 👍 1102 👎 0


package me.alvin.leetcode.editor.cn;

import support.ListNode;
import support.ListTools;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
        ListNode l1 = ListTools.buildLinkedList(new int[]{1,2,3,4,5,6,7,8});
        System.out.println(solution.reverseKGroup(l1,3));
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
        public ListNode reverseKGroup(ListNode head, int k) {
            if (k == 1) {
                return head;
            }
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;

            //找到可以操作的第一个k区间
            ListNode guard = dummyHead;
            ListNode nextGuard = guard.next;
            ListNode walk = guard;
            boolean flag = true;
            while (true) {
                //走k步，如果到了null，则不继续
                for (int i = 0; i < k; i++) {
                    walk = walk.next;
                    if (walk == null) {
                        flag = false;
                        break;
                    }
                }
                if(!flag){
                    break;
                }
                //翻转某个区间的节点并接上
                guard.next = reverseBetweenByHeadInsert(guard.next, 1, k);
                //设置下一个区间的参数
                guard = nextGuard;
                nextGuard = guard.next;
                walk = guard;
            }

            return dummyHead.next;
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