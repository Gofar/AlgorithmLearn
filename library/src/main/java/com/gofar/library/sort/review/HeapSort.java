package com.gofar.library.sort.review;

/**
 * 堆排序
 * 不太懂，还要多理解
 *
 * @author lcf
 * @date 17/7/2018 下午 3:51
 * @since 1.0
 */
public class HeapSort {

    public void sort(int[] nums) {

    }

    public void buildMaxHeap(int[] nums, int lastIndex) {
        for (int i = (lastIndex - 1) / 2; i > 0; i--) {
            int k = i;
            while (2 * k + 1 <= lastIndex) {
                int biggerIndex = 2 * k + 1;
                if (biggerIndex < lastIndex) {
                    if (nums[biggerIndex] < nums[biggerIndex + 1]) {
                        biggerIndex++;
                    }
                }
            }
        }
    }
}
