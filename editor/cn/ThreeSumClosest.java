package cn;

/**
 * 最接近的三数之和
 *
 * @author YangKai
 */
//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。 
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
// Related Topics 数组 双指针 排序 👍 1149 👎 0


public class ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
        // TO TEST
        int[] nums = {1, 1, -1, -1, 3};
        System.out.println(solution.threeSumClosest(nums, -1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int tmp = 0;
            int ans = (int) Math.pow(10, 4);
            // 双指针：
            for (int i = 0; i < nums.length - 2; i++) {
                // 指针1：第一个数
                tmp += nums[i];
                for (int j = i + 1; j < nums.length - 1; j++) {
                    // 指针2：第二个数
                    tmp += nums[j];
                    for (int k = j + 1; k < nums.length; k++) {
                        tmp += nums[k];
                        ans = Math.abs(tmp - target) < Math.abs(ans - target) ? tmp : ans;
                        tmp -= nums[k];
                    }
                    tmp -= nums[j];
                }
                tmp -= nums[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}