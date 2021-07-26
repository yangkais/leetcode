package cn;

/**
 * 接雨水
 *
 * @author YangKai
 */
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 
// 👍 2503 👎 0


public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        // TO TEST
        int[] height = {4, 2, 0, 3, 2, 5};
        System.out.println(solution.trap(height));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int leftMax = 0;
            int rightMax = 0;
            int result = 0;
            // 左右指针遍历
            while (left < right) {
                // 左右两边数据比较：取小的那边开始计算，因为容积是由短的一侧决定的
                if (height[left] < height[right]) {
                    if (leftMax > height[left]) {
                        // 小于左边最小值
                        result += (leftMax - height[left]);
                    } else {
                        // 更新最大值
                        leftMax = height[left];
                    }
                    // 左移
                    left++;
                } else {
                    if (rightMax > height[right]) {
                        result += (rightMax - height[right]);
                    } else {
                        rightMax = height[right];
                    }
                    right--;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}