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

    private void test(int[] nums) {
        int size = nums.length;
        for (int i = (size - 2) / 2; i >= 0; i--) {
            int k = i;
            while (2 * k + 2 < size) {
                int j = 2 * k + 1;
                if (nums[j] < nums[j + 1]) {
                    j++;
                }
                if (nums[k] < nums[j]) {
                    swap(nums, k, j);
                    k = j;
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void test2(int[] nums, int last) {
        for (int i = 0; i < (last - 2) / 2; i++) {
            int k = i;
            while (2 * k + 2 < last) {
                int j = 2 * k + 1;
                if (nums[j] < nums[j + 1]) {
                    j++;
                }
                if (nums[k] < nums[j]) {
                    swap(nums, k, j);
                    k = j;
                }
            }
        }
    }
}
