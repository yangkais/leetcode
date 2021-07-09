package cn;

/**
 * @author YangKai
 * @date Date
 */

//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
// Related Topics 数组 二分查找 分治算法 
// 👍 4116 👎 0

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        int[] nums1 = {0, 0, 0, 0, 0};
        int[] nums2 = {-1, 0, 0, 0, 0, 0, 1};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }

    /**
     * leetcode submit region begin(Prohibit modification and deletion)
     */
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            /**
             * 中位数的定义
             *     1、当 m+n 是奇数时，中位数是两个有序数组中的第 (m+n)/2 个元素；
             *     2、当 m+n 是偶数时，中位数是两个有序数组中的第 (m+n)/2 个元素和第 (m+n)/2+1 个元素的平均值
             */
            int l1 = nums1.length;
            int l2 = nums2.length;
            int totalLength = l1 + l2;
            if (totalLength % 2 == 1) {
                // 总长度为奇数, 中位数
                int midIndex = totalLength / 2 + 1;
                return kNum(nums1, nums2, midIndex);
            } else {
                // 总长度为偶数, 中位数
                int midIndex1 = totalLength / 2;
                int midIndex2 = totalLength / 2 + 1;
                return (kNum(nums1, nums2, midIndex1) + kNum(nums1, nums2, midIndex2)) / 2.0;
            }
        }

        /**
         * 取第k位的数
         *
         * @param nums1 数组1
         * @param nums2 数组2
         * @param k     中位数所处位数
         * @return k位数据
         */
        private double kNum(int[] nums1, int[] nums2, int k) {
            /**
             * 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
             *          这里的 "/" 表示整除
             *          nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
             *          nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
             *          取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
             *          这样 pivot 本身最大也只能是第 k-1 小的元素
             *          如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
             *          如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
             *          由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
             */
            // 数组num1长度
            int length1 = nums1.length;
            // 数组num2长度
            int length2 = nums2.length;
            // 数组num1当前下标
            int index1 = 0;
            // 数组num2当前下标
            int index2 = 0;
            // 结束状态：任一数组越界，或k=1，代表首位，只需比较取最小
            while (true) {
                // 到达num1边界
                if (index1 == length1) {
                    // 中位数只会出现在nums2，也就是当前位index2 + k位的数值，
                    return nums2[k + index2 - 1];
                }
                // 到达num2边界
                if (index2 == length2) {
                    // 中位数只会出现在nums1，也就是当前位index1 + k位的数值，
                    return nums1[index1 + k - 1];
                }
                if (k == 1) {
                    // 中位数第一位时，取两个数组第一位中最小的
                    return Math.min(nums1[index1], nums2[index2]);
                }
                // 正常情况
                int half = k / 2;
                // 新下标：min函数避免越界，后移k/2 - 1
                int newIndex1 = Math.min(index1 + half, length1) - 1;
                int newIndex2 = Math.min(index2 + half, length2) - 1;
                int pivot1 = nums1[newIndex1];
                int pivot2 = nums2[newIndex2];
                if (pivot1 <= pivot2) { // 中位数只会出现在大于pivot1中，排除pivot1之前数据
                    // 处理nums1 : 中位数所处位数，后移newIndex1 - index1 + 1
                    k -= (newIndex1 - index1 + 1);
                    // 下标后移一位
                    index1 = newIndex1 + 1;
                } else {
                    k -= (newIndex2 - index2 + 1);
                    index2 = newIndex2 + 1;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}