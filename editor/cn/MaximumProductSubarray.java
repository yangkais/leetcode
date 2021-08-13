package cn;

/**
 * 乘积最大子数组
 *
 * @author YangKai
 */
//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 1227 👎 0

public class MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumProductSubarray().new Solution();
        // TO TEST
        int[] nums = {2, 3, -2, 4};
        System.out.println(solution.maxProduct(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 动态规划：
         *   dp[i] = nums[i] > 0 ? dp[i-1] * nums[i] : dp[i-1]
         *
         * @param nums
         * @return
         */
        public int maxProduct(int[] nums) {
            // 整个数组最大乘积
            int max = nums[0];
            // 当前下标关联最大乘积
            int maxFlag = nums[0];
            // 当前下标关联最小乘积
            int minFlag = nums[0];
            for (int i = 1; i < nums.length; i++) {
                // 后面会修改
                int tempMax = maxFlag;
                // 求最大乘积：当前数小于0需要与minFlag相乘，负负得正
                maxFlag = Math.max(Math.max(maxFlag * nums[i], nums[i]), minFlag * nums[i]);
                // 同时计算最小乘积
                minFlag = Math.min(Math.min(minFlag * nums[i], nums[i]), tempMax * nums[i]);
                max = Math.max(max, maxFlag);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}