package com.gofar.library.sort.review;

/**
 * 堆排序
 * 堆排序是一种树形选择排序，是对直接选择排序的有效改进。
 * 堆的定义如下：具有n个元素的序列（h1,h2,...hn）,
 * 仅当满足（hi>=h2i,h(2i+1)）或（hi<=h2i,hi<=h(2i+1)）(i=1,2,...n/2)时,称之为堆。
 * 用完全二叉树可以很直观的表示堆的结构，最大堆的堆顶元素为最大项，堆顶为根，其他为左、右子树。
 * <p>
 * 思想：初始时把要排序数组看成一棵顺序存储的二叉树，调整为最大堆，然后将根节点与堆的最后一个元素交换。
 * 然后对前面n-1个元素重新调整为堆，依此类推，直到只有两个节点的堆，并对它们做交换，最后得到有n个节点的有序序列。
 * 算法主要有两个方法，一个建堆，一个是堆顶与堆的最后一个元素交换。循环调用这两个方法直到得到有序序列。
 * 时间复杂度：O(nlogn)
 * 不稳定
 * <p>
 * 完全二叉树如果有子节点，那一定有左子节点，必定满足2i<=n。
 * 最大堆：hi>=h2i,hi>=h(2i+1)
 * n个元素，从1开始，最后一个元素为n,，求i=n/2
 * 数组的下标从0开始，最后一个元素为n-1,调整条件为hi>=h(2i+1),hi>=h(2i+2),求i=((n-1)-1)/2=(n-2)/2
 *
 * @author lcf
 * @date 17/7/2018 下午 3:51
 * @since 1.0
 */
public class HeapSort {

    public void sort(int[] nums) {
        int last = nums.length - 1;
        for (int i = 0; i < last; i++) {
            buildMaxHeap(nums, last - i);
            swap(nums, 0, last - i);
        }
    }

    public void buildMaxHeap(int[] nums, int lastIndex) {
        // 从最后一个节点的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            int k = i;
            while (2 * k + 1 <= lastIndex) {
                int j = 2 * k + 1;
                // 若有右子节点并且右子节点比左子节点大
                if (j < lastIndex && nums[j] < nums[j + 1]) {
                    // j指向右子节点
                    j++;
                }
                // 若父节点比子节点小
                if (nums[k] < nums[j]) {
                    // 父节点与子节点交换
                    swap(nums, k, j);
                    // k指向j，循环比较k的子节点，向下调整
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
