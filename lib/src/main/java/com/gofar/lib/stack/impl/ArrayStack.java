package com.gofar.lib.stack.impl;

import com.gofar.lib.stack.IStack;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * 数组实现栈
 *
 * @author lcf
 * @date 2018/7/3 15:18
 * @since 1.0
 */
public class ArrayStack<E> implements IStack<E> {

    private Object[] elementData = {};
    private int elementCount;

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public ArrayStack() {
    }

    @Override
    public void push(E e) {
        ensureCapacity(elementCount + 1);
        elementData[elementCount++] = e;
    }

    @Override
    public E pop() {
        E obj = top();
        removeElementAt(elementCount - 1);
        return obj;
    }

    @Override
    public E top() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return elementAt(elementCount - 1);
    }

    @Override
    public int search(Object o) {
        int i = lastIndexOf(o);
        if (i >= 0) {
            return elementCount - i;
        }
        return -1;
    }

    @Override
    public boolean empty() {
        return elementCount == 0;
    }

    @Override
    public int size() {
        return elementCount;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayStackIterator();
    }

    /**
     * 测量数组是否容量不足，不足就增加长度
     *
     * @param minCapacity 最少容量
     */
    private void ensureCapacity(int minCapacity) {
        if (minCapacity - elementData.length > 0) {
            grow(minCapacity);
        }
    }

    /**
     * 加大数组的长度
     *
     * @param minCapacity 最少容量
     */
    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }
        if (newCapacity > MAX_ARRAY_SIZE) {
            newCapacity = hugeCapacity(minCapacity);
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private int hugeCapacity(int minCapacity) {
        {
            if (minCapacity < 0) {
                throw new OutOfMemoryError();
            }
            return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
        }

    }

    @SuppressWarnings("unchecked")
    private E elementAt(int index) {
        return (E) elementData[index];
    }

    /**
     * 移除元素
     *
     * @param index 元素index
     */
    private void removeElementAt(int index) {
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + ">=" + elementCount);
        } else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int numMoved = elementCount - index - 1;
        if (numMoved > 0) {
            // 移除元素
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        // 主动置空，以便gc回收
        elementData[--elementCount] = null;
    }

    private int lastIndexOf(Object o) {
        return lastIndexOf(o, elementCount - 1);
    }

    private int lastIndexOf(Object o, int index) {
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + ">=" + elementCount);
        }
        if (o == null) {
            for (int i = index; i >= 0; i--) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = index; i >= 0; i--) {
                if (o.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    private class ArrayStackIterator implements Iterator<E> {

        private int i = elementCount;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public E next() {
            return (E) elementData[--i];
        }
    }
}