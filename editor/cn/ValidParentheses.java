package cn;

import java.util.*;

/**
 * 有效的括号
 *
 * @author YangKai
 */
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2497 👎 0


public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        // TO TEST
        System.out.println(solution.isValid("([)]"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 题目要求左右符号必须按相同顺序排列：([)] = false， ([])=true
         * @param s
         * @return
         */
        public boolean isValid(String s) {
            int length = s.length();
            // 必须对称
            if (length % 2 == 1) {
                return false;
            }
            Map<Character, Character> charMap = new HashMap<>(8);
            charMap.put('(', ')');
            charMap.put('{', '}');
            charMap.put('[', ']');

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                if (charMap.containsKey(c)) { // 左侧字符
                    stack.push(c);
                } else {
                    if (stack.isEmpty() || !charMap.get(stack.peek()).equals(c)) {
                        return false;
                    }
                    stack.pop();
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}