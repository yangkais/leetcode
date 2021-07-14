package cn;

import java.util.*;

/**
 * 电话号码的字母组合
 *
 * @author YangKai
 */
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 
// 👍 1391 👎 0


public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        // TO TEST
        System.out.println(solution.letterCombinations("23"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> combinations = new ArrayList<>(digits.length());
            if (digits.length() == 0) {
                return combinations;
            }
            // 构造键盘数据
            Map<Character, String> phoneMap = new HashMap<Character, String>(16) {{
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }};
            // 回溯函数
            backtrack(digits, phoneMap, 0, combinations, new StringBuffer());
            return combinations;
        }

        /**
         * 按数值字符串深度回溯
         *
         * @param digits       数值字符串
         * @param phoneMap     键盘字符
         * @param index        下标
         * @param combinations 组合后集合
         * @param combination  组合字符
         */
        private void backtrack(String digits, Map<Character, String> phoneMap, int index, List<String> combinations, StringBuffer combination) {
            // 单次拼接字符完成
            if (index == digits.length()) {
                combinations.add(combination.toString());
            } else {
                // 获取数值字符串当前下标对应键盘处字符
                String letters = phoneMap.get(digits.charAt(index));
                int letterCount = letters.length();
                // 循环获取到的字符，按层级循环
                // a b c index=0  =>  e f g index=1 => index=2 到达最大深度 => 移除当前index处字符换下一字符，如a->b
                for (int i = 0; i < letterCount; i++) {
                    combination.append(letters.charAt(i));
                    // 递归调用
                    backtrack(digits, phoneMap, index + 1, combinations, combination);
                    // 前一位字符相同，去掉当前位即可，如a*
                    combination.deleteCharAt(index);
                }
            }
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}