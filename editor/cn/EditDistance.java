package cn;

/**
 * 编辑距离
 *
 * @author YangKai
 */
//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 1720 👎 0


public class EditDistance {
    public static void main(String[] args) {
        Solution solution = new EditDistance().new Solution();
        // TO TEST
        System.out.println(solution.minDistance("a", "ab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 分析：word1[m]全部变成word2[n]有三种方式
         * 1、word1[m-1][n] + 1 => word2[m][n]；即word1插入一个字符
         * 2、word1[m][n-1] + 1 => word2[m][n]；即word1删除一个字符
         * 3、word1[m-1][n-1] => word2[m][n]；即word1替换一个字符 （当m、n位的字符不同时）
         * <p>
         * 动态规划方程式：
         * 1、若word1[i] == word2[j]，则dp[i][j] = Min{dp[i-1][j], dp[i][j-1], dp[i-1][j-1] - 1} + 1
         * 1、若word1[i] != word2[j]，则dp[i][j] = Min{dp[i-1][j], dp[i][j-1], dp[i-1][j-1]} + 1
         *
         * @param word1
         * @param word2
         * @return
         */
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            if (m == 0 || n == 0) {
                return m + n;
            }
            int[][] dp = new int[m][n];
            // 是否已包含当前字符word2.charAt(0)
            boolean flag = false;
            for (int i = 0; i < m; i++) {
                // '1111' '1'
                if (word1.charAt(i) == word2.charAt(0) || flag) {
                    dp[i][0] = i;
                    flag = true;
                } else {
                    dp[i][0] = i + 1;
                }
            }
            // 是否已包含当前字符word1.charAt(0)
            flag = false;
            for (int i = 0; i < n; i++) {
                // '1' '111'
                if (word1.charAt(0) == word2.charAt(i) || flag) {
                    dp[0][i] = i;
                    flag = true;
                } else {
                    dp[0][i] = i + 1;
                }
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1] - 1) + 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}