//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 156 👎 0


package me.alvin.leetcode.editor.cn;

import support.ListNode;

import java.util.Stack;

public class CongWeiDaoTouDaYinLianBiaoLcof{
      public static void main(String[] args) {
           Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        if(null == head){
            return new int[0];
        }
        Stack<Integer> stack = new Stack();
        ListNode node = head;
        while(node != null){
            stack.push(node.val);
            node = node.next;
        }
        int[] result = new int[stack.size()];
        for(int i = 0;i<result.length;i++){
            result[i] = stack.pop();
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }