package cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 多数元素
 *
 * @author YangKai
 */
//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：[2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//
// 进阶： 
//
// 
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
// 
// Related Topics 数组 哈希表 分治 计数 排序 
// 👍 1092 👎 0


public class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
        // TO TEST
        int[] nums = {6, 5, 5};
        System.out.println(solution.majorityElement(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElementByMap(int[] nums) {
            Map<Integer, Integer> visited = new HashMap<>();
            for (int num : nums) {
                int count = visited.getOrDefault(num, 0);
                visited.put(num, count + 1);
            }
            for (Map.Entry<Integer, Integer> entry : visited.entrySet()) {
                if (entry.getValue() > nums.length / 2) {
                    return entry.getKey();
                }
            }
            return 0;
        }

        /**
         * 投票选举法：因为题中存在某个数个数大于 n/2
         * 待定选择一个数，遍历当为这个数时计数器+1，不为计数器-1，当计数器为零时，重新选择下一个数为待定数，直到数组遍历完
         *
         * @param nums
         * @return
         */
        public int majorityElement(int[] nums) {
            // 计数器
            int count = 0;
            // 多数选举人
            int candidate = 0;
            for (int num : nums) {
                if (count == 0) {
                    // 计数器清零，重新选举
                    candidate = num;
                }
                // 为当前选择人，计数器+1，否则-1
                count += candidate == num ? 1 : -1;
            }
            return candidate;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}