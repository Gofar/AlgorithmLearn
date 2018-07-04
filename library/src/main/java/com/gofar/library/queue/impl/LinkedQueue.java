package com.gofar.library.queue.impl;

import android.support.annotation.NonNull;

import com.gofar.library.queue.IQueue;

import java.util.Iterator;

/**
 * 链表实现栈
 *
 * @author lcf
 * @date 2018/7/4 11:26
 * @since 1.0
 */
public class LinkedQueue<E> implements IQueue<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    @Override
    public void add(E e) {
        Node<E> item = new Node<>(last, e, null);
        if (empty()) {
            first = item;
            last = item;
        } else {
            last.next = item;
            last = item;
        }
    }

    @Override
    public E remove() {
        if (empty()) {
            try {
                throw new Exception("queue is empty");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Node<E> item = first;
        first = first.next;
        size--;
        if (empty()) {
            last = null;
        }
        return item.item;
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
        return new LinkedQueueIterator();
    }

    private class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    private class LinkedQueueIterator implements Iterator<E> {
        private Node<E> cur = first;

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