package com.gofar.library.sort.review;

/**
 * 希尔排序
 * 加强版插入排序
 * 首先对数组进行分组，然后将较小值移动到前面，较大值移动到后面，最后将整个数组进行插入排序，
 * 这样比起一开始就用插入排序就减少了数据交换和移动的次数。
 * 时间复杂度：O(n^1.3)
 *
 * @author lcf
 * @date 16/7/2018 下午 4:04
 * @since 1.0
 */
public class ShellSort {
    public void sort(int[] nums) {
        int size = nums.length;
        int increment = size / 2;
        int temp;
        while (increment > 0) {
            for (int i = increment; i < size; i++) {
                for (int j = i; j >= increment; j -= increment) {
                    // 间隔increment的两个数交换
                    if (nums[j] < nums[j - increment]) {
                        temp = nums[j];
                        nums[j] = nums[j - increment];
                        nums[j - increment] = temp;
                    }
                }
            }
            increment = increment / 2;
        }
    }
}
