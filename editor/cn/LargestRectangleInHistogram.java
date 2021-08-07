package cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 柱状图中最大的矩形
 *
 * @author YangKai
 */
//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=105 
// 0 <= heights[i] <= 104 
// 
// Related Topics 栈 数组 单调栈 
// 👍 1467 👎 0


public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
        // TO TEST
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(solution.largestRectangleArea(heights));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 单调栈：确保占中元素是递增或递减
         * 1、从左至右遍历：找到第一个小于当前下标i的数据，保存（不存在为-1）
         * 1、从右至左遍历：找到第一个小于当前下标i的数据，保存（不存在为n）
         * 那当前heights[i]为高矩形的面积为：左右大于它数值的间距
         * 例：2, 1, 5, 6, 2, 3
         * left: -1, -1, 1, 2, 1, 4
         * right: 1, 6, 4, 4 ,6, 6
         * 那么 height = 2，则前后数据间距 1 - (-1) -1
         *
         * @param heights
         * @return
         */
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int[] left = new int[n];
            int[] right = new int[n];
            int max = 0;
            Deque<Integer> stack = new ArrayDeque<>();
            // 从左至右遍历
            for (int i = 0; i < n; i++) {
                // 找出第一个小于当前数据的下标
                while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                    // 将大于它的数据出栈
                    stack.pop();
                }
                left[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            // 清空
            stack.clear();
            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                    // 将大于它的数据出栈
                    stack.pop();
                }
                right[i] = stack.isEmpty() ? n : stack.peek();
                stack.push(i);
            }
            for (int i = 0; i < n; i++) {
                max = Math.max(max, (right[i] - left[i] - 1) * heights[i]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}