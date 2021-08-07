package cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 *
 * @author YangKai
 */
//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 
// 👍 1263 👎 0


public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        // TO TEST
        int[] nums = {1, 2, 3};
        solution.subsets(nums).forEach(System.out::println);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            backtrack(nums, 0, new ArrayList<>());
            return ans;
        }

        void backtrack(int[] nums, int index, ArrayList<Integer> temp) {
            ans.add(new ArrayList<>(temp));
            for (int i = index; i < nums.length; i++) {
                temp.add(nums[i]);
                backtrack(nums, i + 1, temp);
                // 不考虑当前位置数值
                temp.remove(temp.size() - 1);
            }
        }


        public List<List<Integer>> subsets1(int[] nums) {
            backtrack1(nums, 0);
            return ans;
        }

        void backtrack1(int[] nums, int index) {
            if (index > nums.length - 1) {
                ans.add(new ArrayList<>(comb));
                return;
            }
            // 考虑当前位置数值
            comb.add(nums[index]);
            backtrack1(nums, index + 1);
            // 不考虑当前位置数值
            comb.remove(comb.size() - 1);
            backtrack1(nums, index + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}