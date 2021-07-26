package cn;

/**
 * 旋转图像
 *
 * @author YangKai
 */
//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。 
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2：   1 2 3
//           4 5 6
//           7 8 9
//
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[1]]
//输出：[[1]]
// 
//
// 示例 4： 
//
// 
//输入：matrix = [[1,2],[3,4]]
//输出：[[3,1],[4,2]]
// 
//
// 
//
// 提示： 
//
// 
// matrix.length == n 
// matrix[i].length == n 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
// Related Topics 数组 数学 矩阵 
// 👍 937 👎 0


public class RotateImage {
    public static void main(String[] args) {
        Solution solution = new RotateImage().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 实例：                         y轴
         * 1 2 3                         |
         * 4 5 6                         |
         * 7 8 9                   [][] [][] [][]
         * ------------------- [][0] [0][0] [][]-------------- x轴
         * [][] [][] [][]
         * |
         * |
         * 结果：顺时针旋转90 [[7,4,1],[8,5,2],[9,6,3]]
         * 7 4 1
         * 8 5 2
         * 9 6 3
         * 结论：int[2][0] => int[0][0]
         * int[0][1] => int[1][0]
         *
         * @param matrix
         */
        public void rotate(int[][] matrix) {
            if (matrix.length == 0 || matrix.length != matrix[0].length) {
                return;
            }
            int length = matrix.length;
            int times = 0;
            // 区分n是奇偶的情况，最多循环 n/2 次
            while (times <= (length >> 1)) {
                // 当前层边线长度 length - times * 2
                int len = length - (times << 1);
                // 每边长度都是一样循环替换上下左右边的值
                for (int i = 0; i < len - 1; ++i) {
                    // 先保存原左边线的值
                    int temp = matrix[times][times + i];
                    // 旋转后：左边线的值 = 下边线的值
                    matrix[times][times + i] = matrix[times + len - i - 1][times];
                    // 旋转后：下边线的值 = 右边线的值
                    matrix[times + len - i - 1][times] = matrix[times + len - 1][times + len - i - 1];
                    // 旋转后：右边线的值 = 上边线的值
                    matrix[times + len - 1][times + len - i - 1] = matrix[times + i][times + len - 1];
                    // 旋转后：上边线的值 = 左边线的值
                    matrix[times + i][times + len - 1] = temp;
                }
                ++times;
            }
        }

        /**
         * 顺时针旋转90度 = 上下翻转(-90) 再 主对角线翻转
         *
         * @param matrix
         */
        public void rotate1(int[][] matrix) {
            int n = matrix.length;
            // 水平翻转 -90
            for (int i = 0; i < n / 2; ++i) {
                for (int j = 0; j < n; ++j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n - i - 1][j];
                    matrix[n - i - 1][j] = temp;
                }
            }
            // 主对角线翻转 180
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < i; ++j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}