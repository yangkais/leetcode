package cn.sort;

import java.util.Arrays;

/**
 * BubbleSort
 *
 * @author yangkai
 * @date 2021/8/19 10:57 上午
 */


public class InsertionSort {

    /**
     * 插入排序
     * 默认数组是有序的，找到比它小的就插进入
     *
     * @param nums 需要排序的整型数组
     */
    public static void insertionSort(int[] nums) {
        int length = nums.length;
        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < length; i++) {
            int temp = nums[i];
            int j = i;
            // 每次选择子序[0,i]排序，则nums[0,i]是有序的
            while (j > 0 && temp < nums[j - 1]) {
                // 如果前面数更大，指向前面下标，实际上是一个swap操作，找到最第一个比它大的，交换，这样整个子序都是有序的
                nums[j] = nums[j - 1];
                j--;
            }
            if (j != i) {
                // 找到前一个比它大的数，交互
                nums[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        insertionSort(nums);

        System.out.println(Arrays.toString(nums));
    }
}
