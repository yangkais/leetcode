package cn;

/**
 * 反转链表
 *
 * @author YangKai
 */
//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 
// 👍 1895 👎 0


public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
        // TO TEST 1,2,3,4,5
        solution.reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
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
         * 1,2,3,4,5 输出 5,4,3,2,1
         * 递归：1放到整个链表最后
         * 递归：2放到剩余整个链表最后 2,3,4,5
         * 递归：3放到剩余整个链表最后 3,4,5
         *
         * @param head
         * @return
         */
        public ListNode reverseList1(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            // 此处head: 4, 5
            // node: 5  head.next = node
            // 若要变为：5, 4, 则 head.next.next = head  此时存在环：5, 4, 5
            // 所以 head.next = null
            ListNode node = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return node;
        }

        /**
         * 迭代：遍历链表，将prev 指向 next
         * 1,2,3,4,5 输出 5,4,3,2,1
         *
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {
            // 反转链表的头结点
            ListNode prev = null;
            // 当前遍历到的节点
            ListNode cur = head;
            while (cur != null) {
                // 在遍历链表时，将当前节点的 next 指针改为指向前一个节点。由于节点没有引用其前一个节点，
                // 因此必须事先存储其前一个节点。在更改引用之前，还需要存储后一个节点。最后返回新的头引用
                ListNode next = cur.next;
                // 当前遍历到的节点的下一节点为原链表的前一个节点【反转】
                cur.next = prev;
                // 反转链表头结点为当前遍历到的节点
                prev = cur;
                // 当前遍历节点后移
                cur = next;
            }
            // 反转链表的头结点
            return prev;
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