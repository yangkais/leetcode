package cn.sort;

import java.util.Arrays;

/**
 * HeapSort
 *
 * @author yangkai
 * @date 2021/8/19 10:57 上午
 */


public class HeapSort {

    /**
     * 堆排序
     * 1.创建一个堆 H[0……n-1]；
     * 2.把堆首（最大值）和堆尾互换；
     * 3.把堆的尺寸缩小 1，并调用 shift_down(0)，目的是把新的数组顶端数据调整到相应位置；
     * 4.重复步骤 2，直到堆的尺寸为 1。
     *
     * @param nums 需要排序的整型数组
     */
    public void heapSort(int[] nums) {
        int length = nums.length;
        // 1.构造一个大顶堆：h[n] <= h[2*n + 1] && h[n] <= h[2*n + 2]
        buildMaxHeap(nums, length);

        for (int i = length - 1; i > 0; i--) {
            // 把堆首（最大值）和堆尾互换
            swap(nums, 0, i);
            // 把堆的尺寸缩小 1
            length--;
            // 并调用 heapify，目的是把新的数组顶端数据调整到相应位置
            heapify(nums, 0, length);
        }
    }

    private void buildMaxHeap(int[] nums, int length) {
        for (int i = (int) Math.floor(length >> 1); i >= 0; i--) {
            heapify(nums, i, length);
        }
    }

    private void heapify(int[] nums, int i, int length) {
        //左子树和右字数的位置
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        // 当前父节点的位置
        int largest = i;
        // 左子节点 大于 父节点
        if (left < length && nums[left] > nums[largest]) {
            // 如果比当前根元素要大，记录它的位置
            largest = left;
        }
        if (right < length && nums[right] > nums[largest]) {
            // 如果比当前根元素要大，记录它的位置
            largest = right;
        }
        // 如果最大的不是根元素位置，那么就交换
        if (largest != i) {
            swap(nums, i, largest);
            // 继续比较，直到完成一次建堆
            heapify(nums, largest, length);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 3, 5, 2, 1};
        // pivot=0 index=1
        // 5
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
