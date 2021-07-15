package cn;

/**
 * 合并两个有序链表
 *
 * @author YangKai
 */
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
// 👍 1793 👎 0


public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        // 输入：l1 = [1,2,4], l2 = [1,3,4]
        // 输出：[1,1,2,3,4,4]
        solution.mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))), new ListNode(1, new ListNode(3, new ListNode(4))));
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
            // 递归
//            if (l1 == null) {
//                return l2;
//            }
//            if (l2 == null) {
//                return l1;
//            }
//            if (l1.val < l2.val) {
            // l1值小，当前节点为l1此节点，下一节点为l1.next、l2递归后的链表
//                l1.next = mergeTwoLists(l1.next, l2);
            // 返回拼接后的链表l1
//                return l1;
//            } else {
            // l2值小，当前节点为l2此节点，下一节点为l1、l2.next递归后的链表
//                l2.next = mergeTwoLists(l1, l2.next);
//                return l2;
//            }

            // 迭代: 选取头结点
            ListNode preHead = new ListNode(-1);
            // 指针
            ListNode prvNode = preHead;
            // l1、l2都不为空
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    // l1值小，下一节点为l1
                    prvNode.next = l1;
                    // 移动l1
                    l1 = l1.next;
                } else {
                    // l2值小，下一节点为l1
                    prvNode.next = l2;
                    // 移动l2
                    l2 = l2.next;
                }
                // 移动返回链表指针
                prvNode = prvNode.next;
            }
            // 将l1或l2中未遍历完的直接指向返回链表后
            prvNode.next = l1 != null ? l1 : l2;
            // 返回值去掉指定的头结点-1
            return preHead.next;
        }
    }

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
//leetcode submit region end(Prohibit modification and deletion)

}