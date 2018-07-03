package com.gofar.lib.stack.impl;

import com.gofar.lib.stack.IStack;
import com.sun.istack.internal.NotNull;

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
        return 0;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @NotNull
    @Override
    public Iterator<E> iterator() {
        return new LinkedStackIterator();
    }

    private int lastIndexOf(Object o) {
        return lastIndexOf(0, size - 1);
    }

    private int lastIndexOf(Object o, int index) {

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
        private Node<E> cur;

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
