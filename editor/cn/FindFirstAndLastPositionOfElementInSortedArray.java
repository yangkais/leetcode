package cn;

import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author YangKai
 */
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 1111 👎 0


public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // TO TEST
        int[] nums = {-99999,-99998,-9999,-999,-99,-9,-1};
        System.out.println(Arrays.toString(solution.searchRange(nums, 0)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] result = {-1, -1};
            int length = nums.length;
            if (length == 0) {
                return result;
            }
            if (length == 1) {
                return nums[0] == target ? new int[]{0, 0} : result;
            }
            int l = 0;
            int r = length - 1;
            int leftRet = 0;
            int rightRet = length;
            int mid;
            // 分两次二分查找：左下标第一个大于等于target  右下标第一个大于target
            while (l <= r) {
                mid = (l + r) / 2;
                // 左下标第一个大于等于target
                if (nums[mid] >= target) {
                    // 逐步向左逼近
                    r = mid - 1;
                    // 标记左下标
                    leftRet = mid;
                } else {
                    // 逐步向右逼近
                    l = mid + 1;
                }
            }
            l = 0;
            r = length - 1;
            while (l <= r) {
                mid = (l + r) / 2;
                // 右下标第一个大于target
                if (nums[mid] > target) {
                    // 逐步向左逼近
                    r = mid - 1;
                    // 标记左下标
                    rightRet = mid;
                } else {
                    // 逐步向右逼近
                    l = mid + 1;
                }
            }
            rightRet = rightRet -1;
            if (leftRet <= rightRet && rightRet < length && nums[leftRet] == target && nums[rightRet] == target) {
                result[0] = leftRet;
                result[1] = rightRet;
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}