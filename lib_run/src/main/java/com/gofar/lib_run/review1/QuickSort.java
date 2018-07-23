package com.gofar.lib_run.review1;

/**
 * @author lcf
 * @date 23/7/2018 下午 2:03
 * @since 1.0
 */
public class QuickSort {
    public void sort(int[] nums) {
        quick(nums, 0, nums.length - 1);
    }

    private void quick(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int middle = getMiddle(nums, low, high);
        quick(nums, low, middle - 1);
        quick(nums, middle + 1, high);
    }

    private int getMiddle(int[] nums, int low, int high) {
        // 将low的值作为中轴
        int temp = nums[low];
        while (low < high) {
            // 当low小于high,并且high的值大于中轴时，
            // high向低端移动
            while (low < high && nums[high] > temp) {
                high--;
            }
            // 比中轴小的记录移动到低端
            nums[low] = nums[high];
            // 当low小于high，并且low的值小于中轴时，
            // low向高端移动
            while (low < high && nums[low] < temp) {
                low++;
            }
            // 比中轴大的记录移动到高端
            nums[high] = nums[low];
        }
        // 中轴的下标为low
        // 最终中轴将数据分为都比它小和都比它大的两部分
        nums[low] = temp;
        return low;
    }
}
