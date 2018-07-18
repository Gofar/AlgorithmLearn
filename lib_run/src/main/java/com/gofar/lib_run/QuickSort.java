package com.gofar.lib_run;

/**
 * 快速排序
 * @author lcf
 * @date 18/7/2018 下午 5:22
 * @since 1.0
 */
public class QuickSort {

    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
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
        // 初始将low位置的元素作为中轴
        int temp = nums[low];
        while (low < high) {
            // 循环直到low不小于high，
            // 或者从高端往低端找，直到找到比中轴小的元素
            while (low < high && nums[high] > temp) {
                // 比中轴大，满足条件，high往左移
                high--;
            }
            // 将比中轴小的元素移到低端
            nums[low] = nums[high];
            // 循环直到low不小于high，
            // 或者从低端往高端找，直到找到比中轴大的元素
            while (low < high && nums[low] < temp) {
                // 比中轴小，满足条件，low往右移
                low++;
            }
            // 将比中轴大的元素移到高端
            nums[high] = nums[low];
        }
        // 最终找到中轴位置low，中轴左边的元素比中轴小，右边比中轴大
        // 将中轴移动到中轴位置
        nums[low] = temp;
        return low;
    }
}
