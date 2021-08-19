package cn.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * QuickSort
 *
 * @author yangkai
 * @date 2021/8/19 10:57 上午
 */


public class QuickSort {

    /**
     * 快速排序
     * 1.从数组中挑出一个元素，成为"基准"pivot
     * 2.重新排序数组，所有元素比基准小的摆放在基准前面，所有元素比基准大的摆在后面，得到分区partition
     * 3.递归把小于基准和大于基准的子数组排序
     *
     * @param nums 需要排序的整型数组
     */
    Random random = new Random();
    public void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int index = partition(nums, left, right);
            System.out.println(index);
            quickSort(nums, left, index - 1);
            quickSort(nums, index + 1, right);
        }

    }

    private int partition(int[] nums, int left, int right) {
        // 设定基准值（pivot）
        int pivot = random.nextInt(right - left + 1) + left;
        swap(nums, pivot, left);
        // 记录最后一个小于基准点数的下标
        int index = left + 1;
        // 3, 4, 3, 5, 2, 1
        // 3 2 3 5 4 1  index = 1 i = 4
        // 3 2 1 5 4 3  index = 2 i = 5
        for (int i = index; i <= right; i++) {
            // 当小于基准数时
            System.out.println(Arrays.toString(nums));
            // 通过交换将小于基准点的数都移到下标index + 1之前
            if (nums[i] < nums[left]) {
                swap(nums, i, index);
                index++;
            }
            // 当大于基准数时，不作处理 i++
        }
        swap(nums, left, index - 1);
        // 返回基准点排序后所在下标
        return index - 1;
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    public static void main(String[] args) {
        int[] nums = {3, 4, 3, 5, 2, 1};
        // pivot=0 index=1
        // 5
        QuickSort quickSort = new QuickSort();
        quickSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
