package cn;

/**
 * 回文链表
 *
 * @author YangKai
 */
//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 105] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 
// 👍 1087 👎 0


public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        // TO TEST
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
         * 1、通过双指针确认链表的前半部分和后半部分
         * 2、反转后半部分
         * 3、依次遍历原链表和反转后的后半部分链表，是否值相同
         * 4、还原后半部分链表
         *
         * @param head
         * @return
         */
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }
            // 通过快慢指针获取前半部分链表，同时指针指向前半部分的结尾
            ListNode firstHalfEnd = endOfFirstHalf(head);
            // 反转后半部分链表
            ListNode reverseHalf = reverse(firstHalfEnd.next);
            ListNode p1 = head;
            ListNode p2 = reverseHalf;
            boolean result = true;
            // 依次遍历原链表和反转后的后半部分链表，是否值相同
            while (result && p2 != null){
                if (p1.val != p2.val) {
                    result = false;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
            // 还原链表后半部分
            firstHalfEnd.next = reverse(reverseHalf);
            return result;
        }

        private ListNode reverse(ListNode node) {
            // 反转后的链表
            ListNode prev = null;
            // 当前链表节点
            ListNode curr = node;
            while (curr != null) {
                // 保存待反转的节点
                ListNode temp = curr.next;
                // 将当前节点下一节点指向反转后的链表
                curr.next = prev;
                // 反转后的节点
                prev = curr;
                // 遍历下一节点
                curr = temp;
            }
            return prev;
        }

        private ListNode endOfFirstHalf(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}