package cn;

/**
 * 爬楼梯
 *
 * @author YangKai
 */
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 1768 👎 0


public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
        // TO TEST
        System.out.println(solution.climbStairs(54));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * f(i) = f(i-1) + f(i-2)
         * 到达f(i)只有两种：
         *   f(i-1)、1、1
         *   f(i-2)、2
         *
         * @param n
         * @return
         */
        public int climbStairs(int n) {
            // 然后采用滑动窗口
            int left = 0;
            int center = 0;
            int right = 1;
            for (int i = 1; i <= n; i++) {
                left = center;
                center = right;
                right = left + center;
            }
            return right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}