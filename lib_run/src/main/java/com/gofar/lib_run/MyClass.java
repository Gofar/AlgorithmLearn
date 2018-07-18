package com.gofar.lib_run;

public class MyClass {
    public static void main(String[] args) {
        int[] nums = {9, 8, 15, 1, 10, 7, 22, 34, 6, 11};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
        // 对整个数组查找中轴
        // 第一次（l<h）
        // l=0,h=9,temp=9   9, 8, 15, 1, 10, 7, 22, 34, 6, 11
        //     h=8
        // l=0,h=8,temp=9   6, 8, 15, 1, 10, 7, 22, 34, 6, 11
        // l=1
        // l=2
        // l=2,h=8,temp=9   6, 8, 15, 1, 10, 7, 22, 34, 15, 11
        // 第二次（l<h）
        // l=2,h=8,temp=9   6, 8, 15, 1, 10, 7, 22, 34, 15, 11
        //     h=7
        //     h=6
        //     h=5
        // l=2,h=5,temp=9   6, 8, 7, 1, 10, 7, 22, 34, 15, 11
        // l=3
        // l=4
        // l=4,h=5,temp=9   6, 8, 7, 1, 10, 10, 22, 34, 15, 11
        // while结束,中轴位置low=4,将中轴移到中轴位置
        //                  6, 8, 7, 1, 9, 10, 22, 34, 15, 11

        // 递归两个部分 6,8,7,1  10,22,34,15,11
        // 重复上面的步骤查找每个部分的中轴
        // 递归调用直到多个部分都有序，即整个数组有序
    }
}
