package cn;

import java.util.Arrays;

/**
 * 下一个排列
 *
 * @author YangKai
 */
//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 双指针 
// 👍 1221 👎 0


public class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
        // TO TEST // 2,1,3
        int[] nums = {2, 3, 1};
        // 11511  15111
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 下一个更大的数据，若不存在取最小
         *
         * @param nums
         */
        public void nextPermutation(int[] nums) {
            int length = nums.length;
            if (length < 2) {
                return;
            }
            int i = length - 2;
            // 从后往前比对，如果前面数字更大，继续左移直到第一位
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }
            if (i >= 0) {
                /**
                 * 题干：获取【下一个】更大的数据
                 * 经过第一层 while(nums[i] >= nums[i + 1])
                 * 当进入此逻辑：说明i之后的数据都是降序排列【nums[i] >= nums[i + 1]】，要找到这个降序数组当中大于nums[i]最小的数据
                 * 再次进行比对while (nums[i] >= nums[j])
                 * 从后往前，第一次出现nums[i] < nums[j] 也就是所有大于num[i]的最小数据，交换，此时i之后的数据仍是降序排列，进行一次反转
                 *  满足：nums[i] < nums[i+1] >= nums[i+2].... >= nums[j] >= nums[j+1].......降序排列
                 *       nums[i] >= nums[j+1]、nums[i] < nums[j]，即存在nums[j] > nums[i] >= nums[j+1]
                 *  所以i、j交换之后：nums[i+1] >= nums[i+2].... >= nums[j] > nums[i] >= nums[j+1]....... 降序排列
                 */
                int j = length - 1;
                // nums[i]是否大于后面数字，若大则转换，保证
                while (j >= 0 && nums[i] >= nums[j]) {
                    j--;
                }
                swap(nums, i, j);
            }
            // 直接反转：不存在左边数字比右边小，即该数值最大,
            reverse(nums, i + 1);
        }

        private void swap(int[] nums, int l, int r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }

        private void reverse(int[] nums, int start) {
            int l = start;
            int r = nums.length - 1;
            while (l < r) {
                swap(nums, l, r);
                l++;
                r--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}