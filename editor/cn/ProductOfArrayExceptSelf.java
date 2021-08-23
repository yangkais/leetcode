package cn;

/**
 * 除自身以外数组的乘积
 *
 * @author YangKai
 */
//给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之
//外其余各元素的乘积。 
//
// 
//
// 示例: 
//
// 输入: [1,2,3,4]
//输出: [24,12,8,6] 
//
// 
//
// 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。 
//
// 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 进阶： 
//你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。） 
// Related Topics 数组 前缀和 
// 👍 892 👎 0


public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Solution solution = new ProductOfArrayExceptSelf().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 返回除自身以外所有数的乘积
         * 1、记录从左到右除本身外左侧的数乘积 L
         * 2、保存从右到左除本身外右侧的数乘积 R
         * 3、ans = L * R；更新R
         *
         * @param nums
         * @return
         */
        public int[] productExceptSelf(int[] nums) {
            int length = nums.length;
            int[] answer = new int[length];
            answer[0] = 1;
            for (int i = 1; i < length; i++) {
                answer[i] = nums[i - 1] * answer[i - 1];
            }
            int R = 1;
            for (int i = length - 1; i >= 0; i--) {
                // 计算乘积
                answer[i] = answer[i] * R;
                // 更新右侧乘积，给下一个数使用
                R = nums[i] * R;
            }
            return answer;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}