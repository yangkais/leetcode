package cn;

/**
 * 删除链表的倒数第 N 个结点
 *
 * @author YangKai
 */
//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1451 👎 0


public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        // TO TEST
        ListNode listNode = new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = solution.removeNthFromEnd(listNode, 5);
        do {
            System.out.println(result.val);
            result = result.next;
        } while (result != null);

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 我们可以设想假设设定了双指针 p 和 q 的话，当 q 指向末尾的 NULL，p 与 q 之间相隔的元素个数为 n 时，那么删除掉 p 的下一个指针就完成了要求。
     * <p>
     * 设置虚拟节点 dummyHead 指向 head
     * 设定双指针 p 和 q，初始都指向虚拟节点 dummyHead
     * 移动 q，直到 p 与 q 之间相隔的元素个数为 n
     * 同时移动 p 与 q，直到 q 指向的为 NULL
     * 将 p 的下一个节点指向下下个节点
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // 定义两个指针：slow、fast当中间隔n
            ListNode slow = head;
            ListNode fast = head;
            for (int i = 0; i < n; i++) {
                // 移动快指针保持间隔n
                fast = fast.next;
            }
            if (fast == null) { // 若快指针已经移动至最后，删除的为头结点
                return head.next; // 删除头结点返回
            }
            while (fast.next != null) {
                // 移动指针
                slow = slow.next;
                fast = fast.next;
            }
            // 快指针已移动至最后，删除倒数n节点，返回
            slow.next = slow.next.next;
            return head;
        }

    }

    public static class ListNode {
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
//leetcode submit region end(Prohibit modification and deletion)

}