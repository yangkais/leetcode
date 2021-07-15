package cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 *
 * @author YangKai
 */
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1：
//
//  f(n) = f(n-1)f(1) + f(1)f(n-1) + f(1(n-1))
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
//
// 示例 2：
// 2*n -1
//
//输入：n = 2
//输出：["(())","()()"]
//
// 示例 3：
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 1881 👎 0


public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        // TO TEST
        for (String generateParenthesis : solution.generateParenthesis(3)) {
            System.out.println(generateParenthesis);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            backtrack(result, new StringBuffer(), 0, 0, n);
            return result;
        }

        /**
         * 回溯法：当前位置可能出现'(',')'两种字符，依次回溯直到长度到达2n
         * 1、拼接最大长度 2n
         * 2、'(' 最多n
         * 3、')' 个数不能多于'('，即小于'('才可拼接')'
         *
         * @param result 返回集合
         * @param sb     拼接字符
         * @param open   左'('个数
         * @param close  右')'个数
         * @param max    括号的对数
         */
        private void backtrack(List<String> result, StringBuffer sb, int open, int close, int max) {
            if (sb.length() == max * 2) {
                // 拼接最大长度 2n
                result.add(sb.toString());
            }
            // '(' 最多n
            if (open < max) {
                sb.append("(");
                // 拼接下一层级
                backtrack(result, sb, open + 1, close, max);
                // 同时清空当前层级字符，便于下一枚举使用
                sb.deleteCharAt(sb.length() - 1);
            }

            // ')' 个数不能多于'('，即小于'('才可拼接')'
            if (close < open) {
                sb.append(")");
                // 拼接下一层级
                backtrack(result, sb, open, close + 1, max);
                // 同时清空当前层级字符，便于下一枚举使用
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}