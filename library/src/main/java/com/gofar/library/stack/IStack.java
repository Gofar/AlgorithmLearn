package com.gofar.library.stack;

/**
 * 栈
 *
 * @author lcf
 * @date 2018/7/3 15:11
 * @since 1.0
 */
public interface IStack<E> extends Iterable<E>{
    /**
     * 入栈
     *
     * @param e E
     */
    void push(E e);

    /**
     * 出栈
     *
     * @return E
     */
    E pop();

    /**
     * 查看栈顶元素
     *
     * @return E
     */
    E top();

    /**
     * 查找元素在栈中的位置(距离栈顶的index)
     *
     * @param o 要查找的对象
     * @return 在栈中的position，如果不存在就返回-1.
     */
    int search(Object o);

    /**
     * 栈是否是空的
     *
     * @return True if empty.
     */
    boolean empty();

    /**
     * @return 元素数量
     */
    int size();
}
