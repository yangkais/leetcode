package cn;

/**
 * 岛屿数量
 *
 * @author YangKai
 */
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 1280 👎 0


public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
        // TO TEST
        char[][] grid = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println(solution.numIslands(grid));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 深度优先搜索
         *
         * @param grid
         * @return
         */
        public int numIslands(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int lands = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        // 遇到'1' 代表有陆地+1
                        lands++;
                        dfs(grid, i, j, m, n);
                    }
                }
            }
            return lands;
        }

        /**
         * 前后左右遍历，并且将'1'改为'0'，避免重复计算
         *
         * @param grid
         * @param i
         * @param j
         */
        void dfs(char[][] grid, int i, int j, int m, int n) {
            if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') {
                return;
            }
            grid[i][j] = '0';
            dfs(grid, i - 1, j, m, n);
            dfs(grid, i + 1, j, m, n);
            dfs(grid, i, j - 1, m, n);
            dfs(grid, i, j + 1, m, n);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}