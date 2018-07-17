package com.gofar.library.sort.review;

/**
 * 快速排序
 * 通过
 * @author lcf
 * @date 17/7/2018 下午 5:05
 * @since 1.0
 */
public class QuickSort {

    public void sort(int[] nums) {
        quick(nums, 0, nums.length - 1);
    }

    public void quick(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int middle = getMiddle(nums, low, high);
        quick(nums, low, middle - 1);
        quick(nums, middle + 1, high);
    }

    /**
     * 查找出中轴
     *
     * @param nums 待查找数组
     * @param low  开始位置
     * @param high 结束位置
     * @return 中轴所在位置
     */
    public int getMiddle(int[] nums, int low, int high) {
        // 先将low作为中轴
        int temp = nums[low];
        while (low < high) {
            while (low < high && nums[high] > temp) {
                high--;
            }
            // 比中轴小的记录移动到低端
            nums[low] = nums[high];
            while (low < high && nums[low] < temp) {
                low++;
            }
            // 比中轴大的记录移动到高端
            nums[high] = nums[low];
        }
        nums[low] = temp;
        return low;
    }
}
