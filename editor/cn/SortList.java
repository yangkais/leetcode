package cn;

/**
 * 排序链表
 *
 * @author YangKai
 */
//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
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
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 链表 双指针 分治 排序 归并排序 
// 👍 1249 👎 0


public class SortList {
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
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
        public ListNode sortList(ListNode head) {
            // 快慢指针：当快指针到达末尾则，慢指针刚好
            return sortList(head, null);
        }

        ListNode sortList(ListNode head, ListNode tail) {
            if (head == null) {
                return null;
            }
            if (head.next == tail) {
                head.next = null;
                return head;
            }
            ListNode slow = head;
            ListNode fast = head;
            // 还未到末尾
            while (fast != tail) {
                slow = slow.next;
                fast = fast.next;
                // 还未到末尾
                if (fast != tail) {
                    fast = fast.next;
                }
            }
            ListNode mid = slow;
            ListNode l1 = sortList(head, mid);
            ListNode l2 = sortList(mid, tail);
            return merge(l1, l2);
        }

        /**
         * 合并两个有序列表
         *
         * @param node1
         * @param node2
         * @return
         */
        public ListNode merge(ListNode node1, ListNode node2) {
            // 虚拟头结点
            ListNode  head = new ListNode(-1);
            // 移动节点
            ListNode prevNode = head;
            while (node1 != null && node2 != null) {
                if (node1.val >= node2.val) {
                    prevNode.next = node2;
                    node2 = node2.next;
                } else {
                    prevNode.next = node1;
                    node1 = node1.next;
                }
                prevNode = prevNode.next;
            }
            prevNode.next = node1 != null ? node1 : node2;
            return head.next;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public class ListNode {
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