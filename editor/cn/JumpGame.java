package cn;

/**
 * 跳跃游戏
 *
 * @author YangKai
 */
//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// 0 <= nums[i] <= 105 
// 
// Related Topics 贪心 数组 动态规划 
// 👍 1276 👎 0


public class JumpGame {
    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
        // TO TEST
        int[] nums = {0, 2, 3};
        System.out.println(solution.canJump(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 2,3,1,1,4
         * <p>
         * 贪心：
         * 存在下标 i <= rightMost，使得 i + nums[i] >= y 成立；
         * 其中 rightMost=Max[0...i-1]能到达的最大距离， i <= rightMost，y >= length - 1
         *
         * @param nums
         * @return
         */
        public boolean canJump(int[] nums) {
            int length = nums.length;
            // 可达到右侧最大长度
            int rightMost = 0;
            for (int i = 0; i < length; i++) {
                // 判断当前位置是否可达
                if (i <= rightMost) {
                    // 如果可达，则对比当前点最大可达长度与历史最大可达长度，取最大值
                    rightMost = Math.max(rightMost, i + nums[i]);
                }
                if (rightMost >= length - 1) { // 最终点是否可达
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}