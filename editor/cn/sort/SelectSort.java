package cn.sort;

import java.util.Arrays;

/**
 * BubbleSort
 *
 * @author yangkai
 * @date 2021/8/19 10:57 上午
 */


public class SelectSort {

    /**
     * 选择排序
     * 循环找到数组最小元素，与数组第一位交换
     *
     * @param nums 需要排序的整型数组
     */
    public static void selectSort(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (nums[j] < nums[i]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        selectSort(nums);

        System.out.println(Arrays.toString(nums));
    }
}
