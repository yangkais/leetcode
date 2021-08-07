package cn;

/**
 * 单词搜索
 *
 * @author YangKai
 */
//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SE
//E"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 
// 👍 972 👎 0


public class WordSearch {
    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
        // TO TEST
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABC";
        System.out.println(solution.exist(board, word));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean exist(char[][] board, String word) {
            // 上下左右四个方向回溯
            int m = board.length;
            int n = board[0].length;
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (backtrack(board, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
            return false;
        }

        boolean backtrack(char[][] board, String word, int i, int j, int index, boolean[][] visited) {

            if (board[i][j] != word.charAt(index)) {
                return false;
            } else if (index == word.length() - 1) {
                // 匹配成功
                return true;
            }
            visited[i][j] = true;
            boolean result = false;
            // 上下左右可能的方向
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] direction : directions) {
                int newi = i + direction[0];
                int newj = j + direction[1];
                if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                    if (!visited[newi][newj] && backtrack(board, word, newi, newj, index + 1, visited)) {
                        result = true;
                        break;
                    }
                }
            }
            visited[i][j] = false;
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}