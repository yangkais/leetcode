package cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 *
 * @author YangKai
 */
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 排序 
// 👍 3491 👎 0


public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        // TO TEST
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            // 排序 + 双向指针 两层循环
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            // 外层循环：枚举a, 确认当前数a的补数
            for (int first = 0; first < nums.length; ++first) {
                int target = -nums[first];
                // 同一层不允许数值相同
                if (first > 0 && nums[first] == nums[first - 1]) {
                    continue;
                }
                // 第二层：双向指针，枚举b，b+c累加值为外层数据a的补数
                for (int second = first + 1; second < nums.length; ++second) {
                    // c的起始指针为最右侧
                    int third = nums.length - 1;
                    // 同一层b不允许数据重复
                    if (second > first + 1 && nums[second] == nums[second - 1]) {
                        continue;
                    }
                    // 若b+c累加值大于a的补数，左移c的指针
                    while (second < third && nums[second] + nums[third] > target) {
                        third--;
                    }
                    // 指针重合结束
                    if (second == third) {
                        break;
                    }
                    // 返回目标数组
                    if (nums[second] + nums[third] == target) {
                        List<Integer> one = new ArrayList<>(3);
                        one.add(nums[first]);
                        one.add(nums[second]);
                        one.add(nums[third]);
                        result.add(one);
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}