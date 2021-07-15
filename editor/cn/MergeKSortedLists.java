package cn;

import java.util.PriorityQueue;

/**
 * 合并K个升序链表
 *
 * @author YangKai
 */
//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 链表 分治 堆（优先队列） 归并排序 
// 👍 1383 👎 0


public class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        // TO TEST
        ListNode[] lists = {new ListNode(),
                new ListNode(),
                new ListNode()};
        ListNode listNode = solution.mergeKLists(lists);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

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
         * 按每次两个链表依次合并
         *
         * @param lists
         * @return
         */
        public ListNode mergeKListsOneByOne(ListNode[] lists) {
            int n = lists.length;
            if (n == 0) {
                return null;
            }
            ListNode returnNode = lists[0];
            if (n == 1) {
                return returnNode;
            }

            // 按每次两个链表依次合并
            for (int i = 1; i < n; i++) {
                returnNode = mergeTwoLists(returnNode, lists[i]);
            }

            return returnNode;

        }

        /**
         * 分治合并：两两合并直至结束
         *
         * @param lists
         * @return
         */
        public ListNode mergeKLists(ListNode[] lists) {
            // 分治合并
            return merge(lists, 0, lists.length - 1);
        }

        /**
         * 优先队列PriorityQueue
         *
         * @param lists
         * @return
         */
        public ListNode mergeKListsByQueue(ListNode[] lists) {
            PriorityQueue<Status> queue = new PriorityQueue<>();
            for (ListNode list : lists) {
                // 先将链表头部节点（最小）放入优先队列，完成排序
                if (list != null) {
                    queue.offer(new Status(list.val, list));
                }

            }
            // 返回对象：构造虚拟节点
            ListNode head = new ListNode(-1);
            // 移动指针
            ListNode tail = head;
            // 优先队列还存在数据
            while (!queue.isEmpty()) {
                // 取出排好顺序的对象
                Status f = queue.poll();
                // 将链表数据赋值
                tail.next = f.prv;
                // 移动指针
                tail = tail.next;
                if (f.prv.next != null) {
                    // 依次从当前最小头部节点对应链表中取出下一节点排序
                    queue.offer(new Status(f.prv.next.val, f.prv.next));
                }
            }
            // 去掉虚拟节点返回
            return head.next;
        }

        class Status implements Comparable<Status> {
            int val;
            ListNode prv;

            public Status(Integer val, ListNode prv) {
                this.val = val;
                this.prv = prv;
            }

            @Override
            public int compareTo(Status s) {
                return this.val - s.val;
            }
        }

        /**
         * 分治合并：两两合并
         *
         * @param lists 链表数组
         * @param left  左下标
         * @param right 右下标
         * @return
         */
        private ListNode merge(ListNode[] lists, int left, int right) {
            // 指向同一下标返回该链表
            if (left == right) {
                return lists[left];
            }
            if (left > right) {
                return null;
            }
            // 取左右下标中位数
            int mid = (left + right) >> 1;
            // 递归调用分治合并
            return mergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));
        }

        /**
         * 合并两个有序链表
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null || l2 == null) {
                return l1 == null ? l2 : l1;
            }
            ListNode head = new ListNode(-1);
            ListNode prv = head;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    prv.next = l1;
                    l1 = l1.next;
                } else {
                    prv.next = l2;
                    l2 = l2.next;
                }
                prv = prv.next;
            }
            prv.next = l1 == null ? l2 : l1;
            return head.next;
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