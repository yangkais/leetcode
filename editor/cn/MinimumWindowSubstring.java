package cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 *
 * @author YangKai
 */
//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 
// 👍 1260 👎 0


public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        // TO TEST
        System.out.println(solution.minWindow("a", "aa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        Map<Character, Integer> origin = new HashMap<>();
        Map<Character, Integer> target = new HashMap<>();

        /**
         * @param s
         * @param t
         * @return
         */
        public String minWindow(String s, String t) {
            int tLen = t.length();
            for (int i = 0; i < tLen; i++) {
                origin.put(t.charAt(i), origin.getOrDefault(t.charAt(i), 0) + 1);
            }
            int left = 0;
            int right = 0;
            int ansL = 0;
            int ansR = 0;
            int len = Integer.MAX_VALUE;
            while (right < s.length() && len > tLen) {
                if (origin.containsKey(s.charAt(right))) {
                    target.put(s.charAt(right), target.getOrDefault(s.charAt(right), 0) + 1);
                }
                while (check() && left <= right) {
                    if (right - left + 1 < len) {
                        len = right - left + 1;
                        ansL = left;
                        ansR = left + len;
                    }
                    if (target.containsKey(s.charAt(left))) {
                        target.put(s.charAt(left), target.getOrDefault(s.charAt(left), 1) - 1);
                    }
                    left++;
                }
                right++;
            }
            return len == Integer.MAX_VALUE ? "" : s.substring(ansL, ansR);
        }

        private boolean check() {
            return origin.keySet().stream().noneMatch(t -> target.getOrDefault(t, 0) < origin.get(t));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}