package cn;

/**
 * 最大矩形
 *
 * @author YangKai
 */
//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 
//
// 示例 1： 
//  横向 + 纵向  f[i][j] ..... f[i][j] = i * j = f[i-1][j-1] + i + j - 1
//  f[i][j] ...f[i+m-1][j+n-1] + m + n - 1
//  f[i][j] ..f[i][j+n]    f[i]f[j] ... f[i+m][j]
//输入：matrix = [["1","0","1","0","0"],
//               ["1","0","1","1","1"],
//               ["1","1","1","1","1"],
//               ["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = [["1"]]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = [["0","0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 0 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 栈 数组 动态规划 矩阵 单调栈 
// 👍 983 👎 0


public class MaximalRectangle {
    public static void main(String[] args) {
        Solution solution = new MaximalRectangle().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}