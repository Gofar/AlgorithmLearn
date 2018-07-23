package com.gofar.lib_run.review1;

/**
 * @author lcf
 * @date 23/7/2018 下午 3:33
 * @since 1.0
 */
public class ReviewTest1 {
    public static void main(String[] args) {
        int[] nums = {16, 25, 1, 13, 4, 9, 32, 18, 24, 11};

//        BubbleSort bubbleSort=new BubbleSort();
//        bubbleSort.sort(nums);

//        SelectSort selectSort=new SelectSort();
//        selectSort.sort(nums);

//        InsertSort insertSort=new InsertSort();
//        insertSort.sort(nums);

        ShellSort shellSort=new ShellSort();
        shellSort.sort(nums);
    }
}
