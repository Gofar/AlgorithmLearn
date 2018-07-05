package com.gofar.library.sort;

/**
 * 排序
 *
 * @author lcf
 * @date 2018/7/5 14:20
 * @since 1.0
 */
public abstract class BaseSort<T extends Comparable<T>> {
    /**
     * 排序
     *
     * @param nums 要排序的数组
     */
    public abstract void sort(T[] nums);

    /**
     * 比较大小
     *
     * @param v
     * @param w
     * @return
     */
    protected boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换元素
     *
     * @param a
     * @param i
     * @param j
     */
    protected void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
