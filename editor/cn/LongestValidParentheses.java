package cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最长有效括号
 *
 * @author YangKai
 */
//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 栈 字符串 动态规划 
// 👍 1370 👎 0


public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
        // TO TEST
        System.out.println(solution.longestValidParentheses2("(()"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            int max = 0;
            /**
             * 存储'('下标,  当stack为空存储')'下标【用于标记边界】，每次'('、')'匹配成功计算长度
             * 0 1 2 3 4 567 89)
             * ( ( ) ) ) ((( )))
             */
            Deque<Integer> stack = new LinkedList<>();
            // 用于计算第一组匹配的长度:1-(-1) = 2
            stack.push(-1);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    // 匹配之后出栈【若前面子串全部匹配将-1也出栈】
                    stack.pop();
                    // 当stack为空存储')'下标【用于标记边界】
                    if (stack.isEmpty()) {
                        // 先出后进依次更新边界值
                        stack.push(i);
                    } else {
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
            return max;
        }

        /**
         * 两次循环：记录'('、')'个数，左右循环是为了解决'(()' 【left > right】未到达计算长度条件
         *
         * @param s
         * @return
         */
        public int longestValidParentheses2(String s) {
            int left = 0, right = 0, max = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    left++;
                } else {
                    right++;
                }
                if (left < right) {
                    // 右括号')'更多子串不满足条件，重新匹配
                    left = right = 0;
                } else if (left == right) {
                    // 相等则长度*2
                    max = Math.max(max, right * 2);
                }
            }
            // 右循环一次 解决 '(()' 未到达统计长度问题
            left = right = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == '(') {
                    left++;
                } else {
                    right++;
                }
                if (left == right) {
                    // 相等则长度*2
                    max = Math.max(max, right * 2);
                } else if (left > right) {
                    left = right = 0;
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}