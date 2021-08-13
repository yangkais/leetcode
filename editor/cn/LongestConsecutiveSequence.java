package cn;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 *
 * @author YangKai
 */
//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// 
// Related Topics 并查集 数组 哈希表 
// 👍 862 👎 0


public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
        // TO TEST
        int[] nums = {100, 4, 200, 1, 3, 2};
        solution.longestConsecutive(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> numSet = new HashSet<>();
            // 保存数据，去重
            for (int num : nums) {
                numSet.add(num);
            }

            int longestSequence = 0;
            for (int num : numSet) {
                // 判断前一个数据是否存在，避免重复判断子序列 [1,2,3] [2,3]
                if (!numSet.contains(num - 1)) {
                    // 当前数据未被其他子序列选取过，保证从子序列最左侧数据开始递增
                    int currentNum = num;
                    int currentSequence = 1;
                    // 选取当前数据递增，取最长子序列
                    while (numSet.contains(currentNum + 1)) {
                        currentNum++;
                        currentSequence++;
                    }
                    longestSequence = Math.max(currentSequence, longestSequence);
                }
            }
            return longestSequence;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}