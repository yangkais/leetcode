package cn;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * 数组中的第K个最大元素
 *
 * @author YangKai
 */
//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 1230 👎 0


public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        // TO TEST
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(solution.findKthLargest(nums, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest1(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for (int num : nums) {
                queue.add(num);
            }
            for (int i = 0; i < k - 1; i++) {
                queue.poll();
            }
            return queue.poll();
        }

        /**
         * 快速排序：
         * 1、分解：随机选择一个下标i，遍历使得nums[0,i-1] <= nums[i] && nums[i] <= nums[i+1, n]
         * 2、解决：递归使用快速排序对子数组nums[0,i-1]、nums[i+1, n]
         * 3、合并：
         *
         * @param nums
         * @param k
         * @return
         */
        Random random = new Random();

        public int findKthLargest2(int[] nums, int k) {
            return quickSelect(nums, 0, nums.length - 1, nums.length - k);
        }

        private int quickSelect(int[] nums, int l, int r, int index) {
            int q = randomPartition(nums, l, r);
            if (q == index) {
                return nums[q];
            }
            // 下标在目标之前：左移；下标在目标之后，右移
            return q < index ? quickSelect(nums, q + 1, r, index) : quickSelect(nums, l, q - 1, index);
        }

        private int randomPartition(int[] nums, int l, int r) {
            int i = random.nextInt(r - l + 1) + l;
            swap(nums, i, r);
            return partition(nums, l, r);
        }

        private int partition(int[] nums, int l, int r) {
            int x = nums[r];
            int i = l - 1;
            for (int j = l; j < r; j++) {
                if (nums[j] <= x) {
                    swap(nums, ++i, j);
                }
            }
            swap(nums, i + 1, r);
            return i + 1;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        /**
         * 堆排序
         *
         * @param nums
         * @param k
         * @return
         */
        public int findKthLargest(int[] nums, int k) {
            int heapSize = nums.length;
            // 构造大顶堆: 倒序排列
            buildMaxHeap(nums, nums.length);
            for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
                // 将最大数据放到队尾
                swap(nums, 0, i);
                --heapSize;
                // 对前n-1进行堆排序
                heapify(nums, 0, heapSize);
            }
            return nums[0];
        }

        private void buildMaxHeap(int[] nums, int length) {
            for (int i = length / 2; i >= 0; i--) {
                heapify(nums, i, length);
            }
        }

        private void heapify(int[] nums, int i, int length) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;
            if (left < length && nums[left] > nums[largest]) {
                largest = left;
            }
            if (right < length && nums[right] > nums[largest]) {
                largest = right;
            }
            if (largest != i) {
                swap(nums, i, largest);
                heapify(nums, largest, length);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}