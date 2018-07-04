package com.gofar.library.stack.impl;

import android.support.annotation.NonNull;

import com.gofar.library.stack.IStack;

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * @author lcf
 * @date 2018/7/3 17:22
 * @since 1.0
 */
public class LinkedStack<E> implements IStack<E> {
    private Node<E> top;
    private int size;

    @Override
    public void push(E e) {
        top = new Node<>(e, top);
        size++;
    }

    @Override
    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        E item = top.item;
        top = top.next;
        size--;
        return item;
    }

    @Override
    public E top() {
        if (empty()) {
            throw new EmptyStackException();
        }
        if (top != null) {
            return top.item;
        }
        return null;
    }

    @Override
    public int search(Object o) {
        return lastIndexOf(o);
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @NonNull
    @Override
    public Iterator<E> iterator() {
        return new LinkedStackIterator();
    }

    private int lastIndexOf(Object o) {
        return lastIndexOf(o, 0);
    }

    private int lastIndexOf(Object o, int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(index + ">=" + size);
        }
        if (o == null) {
            int i = index;
            Node<E> t = top;
            while (i < size) {
                if (t.item == null) {
                    return i;
                }
                t = t.next;
                i++;
            }
        } else {
            int i = index;
            Node<E> t = top;
            while (i < size) {
                if (o.equals(t.item)) {
                    return i;
                }
                t = t.next;
                i++;
            }
        }
        return -1;
    }

    private class Node<E> {
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    private class LinkedStackIterator implements Iterator<E> {
        private Node<E> cur = top;

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public E next() {
            E item = cur.item;
            cur = cur.next;
            return item;
        }
    }
}
