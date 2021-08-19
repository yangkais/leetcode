package cn;

/**
 * 最大正方形
 *
 * @author YangKai
 */
//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 数组 动态规划 矩阵 
// 👍 842 👎 0


public class MaximalSquare {
    public static void main(String[] args) {
        Solution solution = new MaximalSquare().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 动态规划： dp[i, j] = Min{dp[i-1, j], dp[i, j -1], dp[i-1, j -1]} + 1
         *
         * @param matrix
         * @return
         */
        public int maximalSquare(char[][] matrix) {
            // 最大正方形边长
            int maxSide = 0;
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            // 以当前下标为右下角正方形边长
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') {
                        if (i == 0 || j == 0) {
                            dp[i][j] = 1;
                        } else {
                            dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                        }
                        maxSide = Math.max(maxSide, dp[i][j]);
                    }
                }
            }
            return maxSide * maxSide;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}