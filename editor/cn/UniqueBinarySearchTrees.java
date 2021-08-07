package cn;

/**
 * 不同的二叉搜索树
 *
 * @author YangKai
 */
//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 
// 👍 1256 👎 0


public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees().new Solution();
        // TO TEST
        System.out.println(solution.numTrees(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 动态规划：
         * 定义：
         *   G(n): 长度为n的序列能构成的不同二叉搜索树的个数。
         *   F(i,n): 以 i为根、序列长度为n的不同二叉搜索树个数 (1≤i≤n)
         * 那么：
         *   以i为根的二叉树个数：左子树[0... i-1]与右子树[i+1... n]的笛卡尔积
         *   F(i,n) = G(i -1) * G(n - i)
         *   G(n) = SUM {F(i,n)} [1≤i≤n]；序列长度n得到的总个数为根选择[1≤i≤n]个数之和
         * 其中：
         *   G(0) = 1; G(1) = 1;
         *
         * @param n 长度
         * @return
         */
        public int numTrees(int n) {
            int[] G = new int[n + 1];
            G[0] = 1;
            G[1] = 1;
            // 第一层循环：二叉树的长度，依次得到长度为n的总数
            for (int i = 2; i <= n; i++) {
                // 第二层循环：长度为i二叉树的根j
                for (int j = 1; j <= i; j++) {
                    // 累加得到对应序列长度的总数和
                    G[i] += G[j - 1] * G[i - j];
                }
            }
            return G[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}