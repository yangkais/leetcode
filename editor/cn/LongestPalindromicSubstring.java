package cn;

/**
 * @author YangKai
 * @date Date
 */

//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "spreadCenterPoint"
//输出："spreadCenterPoint"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："spreadCenterPoint"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3672 👎 0

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("bbbb"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
        public String longestPalindrome(String s) {
            // 判断是否为空
            if (s == null || s.length() == 0) {
                return "";
            }
            // 回文串起始、结束下标，用来标记最长回文子串end-start
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                // 移动下标s[i]作为中心点扩散，回文中心字符个数为奇数，如[bbb]
                int len1 = spreadCenterPoint(s, i, i);
                // 移动下标s[i]、s[i+1]作为中心点扩散，回文中心字符为偶数，如[bb]
                int len2 = spreadCenterPoint(s, i, i + 1);
                int len = Math.max(len1, len2);
                // 当前回文串长度更长
                if (len > end - start + 1) {
                    // 上一步存在i+1取数
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        /**
         * 中心扩散法
         * @param s 字符串
         * @param left 左起始下标
         * @param right 右起始下标
         * @return 回文串长度
         */
        private int spreadCenterPoint(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                // 左右扩散，直至对称位不相等
                --left;
                ++right;
            }
            return right - left - 1;
        }
    }

//leetcode submit region end(Prohibit modification and deltion)

//    // 存放不重复子串
//    Set<Character> sub = new HashSet<>();
//    List<Character> result = new ArrayList<>();
//    int length = s.length();
//    // 右指针
//    int rk = 0;
//        for (int i = 0; i < length; i++) {
//        if (i > 0) {
//            // 此处i已+1
//            char c = s.charAt(i - 1);
//            // 首位重复：回文, 并且已存在回文串小于当前
//            if (rk < length && s.charAt(rk) == c && result.size() - 1 < sub.size()) {
//                // 重新赋值
//                result.addAll(sub);
//                result.add(c);
//            }
//            // 移除当前循环首位字符
//            sub.remove(c);
//        }
//        // 存在重复字符
//        while (rk < length && !sub.contains(s.charAt(rk))) {
//            sub.add(s.charAt(rk));
//            rk++;
//        }
//    }
//    StringBuffer sb = new StringBuffer();
//        for (Character ch: result) {
//        sb.append(ch);
//    }
//        return sb.toString();

}