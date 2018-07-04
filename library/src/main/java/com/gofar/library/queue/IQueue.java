package com.gofar.library.queue;

/**
 * @author lcf
 * @date 2018/7/4 11:08
 * @since 1.0
 */
public interface IQueue<E> extends Iterable<E> {
    /**
     * 插入元素
     *
     * @param e E
     * @return
     */
    void add(E e);

    /**
     * 检索并删除头部
     *
     * @return
     */
    E remove();

    /**
     * 是否为空
     *
     * @return
     */
    boolean empty();

    /**
     * 元素数量
     *
     * @return
     */
    int size();
}