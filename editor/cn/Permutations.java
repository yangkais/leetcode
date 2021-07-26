package cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 全排列
 *
 * @author YangKai
 */
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 
// 👍 1456 👎 0


public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        // TO TEST
        int[] nums = {1, 2, 3};
        System.out.println(solution.permute(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            int length = nums.length;
            boolean[] used = new boolean[length];
            backtrack(nums, length, 0, used, ans, new ArrayDeque<>());
            return ans;
        }

        private void backtrack(int[] nums, int length, int depth, boolean[] used, List<List<Integer>> ans, Deque<Integer> comb) {
            if (depth == length) {
                ans.add(new ArrayList<>(comb));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    comb.addLast(nums[i]);
                    used[i] = true;
                    backtrack(nums, length, depth + 1, used, ans, comb);
                    used[i] = false;
                    comb.removeLast();
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}