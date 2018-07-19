package com.gofar.lib_run;

import java.util.Arrays;

/**
 * @author lcf
 * @date 19/7/2018 下午 2:48
 * @since 1.0
 */
public class HeapSort {

    public void sort(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            buildMaxHeap(nums, size - 1 - i);
            swap(nums, 0, size - 1 - i);
            System.out.println(Arrays.toString(nums));
        }
    }

    private void buildMaxHeap(int[] nums, int last) {
        // 从最后一个节点的父节点开始
        for (int i = (last - 1) / 2; i >= 0; i--) {
            int k = i;
            while (2 * k + 1 <= last) {
                System.out.println("k:" + k);
                int j = 2 * k + 1;
                // 右节点比左节点大
                if (j < last && nums[j] < nums[j + 1]) {
                    j++;
                }
                // 父节点比子节点（左、右节点中较大的）小，就将大值交换给父节点
                if (nums[k] < nums[j]) {
                    swap(nums, k, j);
                    System.out.println("swap:" + k + "&" + Arrays.toString(nums));
                    // 将较大节点选为父节点，循环比较父节点与子节点
                    k = j;
                } else {
                    break;
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
