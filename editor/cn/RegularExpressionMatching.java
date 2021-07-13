package cn;

/**
 * 正则表达式匹配
 *
 * @author YangKai
 */
//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// 
// '.' 匹配任意单个字符 
// '*' 匹配零个或多个前面的那一个元素 
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
// 
//
// 示例 1： 
//
// 
//输入：s = "aa" p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 
//输入：s = "aa" p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3： 
//
// 
//输入：s = "ab" p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4： 
//
// 
//输入：s = "aab" p = "c*a*b"
//输出：true
//解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5： 
//
// 
//输入：s = "mississippi" p = "mis*is*p*."
//输出：false 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 20 
// 0 <= p.length <= 30 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 保证每次出现字符 * 时，前面都匹配到有效的字符 
// 
// Related Topics 递归 字符串 动态规划 
// 👍 2223 👎 0


public class RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new RegularExpressionMatching().new Solution();
        // TO TEST
        System.out.println(solution.isMatch("aab", "c*a*b"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();

            // 递归匹配字符串；下标为子串长度，匹配结果组装为二位数组
            boolean[][] f = new boolean[m + 1][n + 1];
            // 空字符串
            f[0][0] = true;
            // 遍历s
            for (int i = 0; i <= m; ++i) {
                // 遍历p，下标从1开始
                for (int j = 1; j <= n; ++j) {
                    // s、p子串匹配，取当前p子串最后一位，是否为'*'
                    if (p.charAt(j - 1) == '*') {  // 一、不匹配字符，将该组合扔掉，不再进行匹配; 二、匹配s末尾的一个字符，将该字符扔掉，而该组合还可以继续进行匹配；
                        //一： p子串[0-j]，因为*会导致前一个字符出现0或者多次，所以其结果与向左倒序再匹配一位的结果一致
                        f[i][j] = f[i][j - 2]; // j-2: 因为++j再加去掉*
                        if (matches(s, p, i, j - 1)) {
                            // 二、匹配s末尾的一个字符，将该字符扔掉，而该组合还可以继续进行匹配
                            // 两者情况任意满足f[i][j]都为true
                            f[i][j] = f[i][j] || f[i - 1][j];
                        }
                    } else { // 最后一位不为*
                        if (matches(s, p, i, j)) {
                            // 若子串最后字符匹配，则结果与f[i - 1][j - 1]相同
                            f[i][j] = f[i - 1][j - 1];
                        }
                    }
                }
            }
            return f[m][n];
        }

        /**
         * 当前位置字符是否匹配
         *
         * @param s s子串
         * @param p p子串
         * @param i s下标
         * @param j p下标
         * @return 是否匹配
         */
        private boolean matches(String s, String p, int i, int j) {
            if (i == 0) { // 未匹配
                return false;
            }
            // 任意匹配'.'
            if (p.charAt(j - 1) == '.') {
                return true;
            }
            // s、p子串当前位置是否为同一字符
            return s.charAt(i - 1) == p.charAt(j - 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
