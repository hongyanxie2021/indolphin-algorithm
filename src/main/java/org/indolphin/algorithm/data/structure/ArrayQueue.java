package org.indolphin.algorithm.data.structure;

import org.indolphin.algorithm.exception.ItemFullException;

/**
 * 基于数组实现队列
 * @author hongyan
 * @param <T> 泛型参数
 */
public class ArrayQueue<T> {

    private T[] data;
    /**
     * 队列底层数组大小
     */
    private int maxSize;
    /**
     * 队列第一个元素前一个位置
     */
    private int front;
    /**
     * 队列最后一个元素的位置
     */
    private int rear;

    public ArrayQueue(int arrayMaxSize) {
        this.maxSize = arrayMaxSize;
        this.data = (T[]) new Object[arrayMaxSize];
        this.front = -1;
        this.rear = -1;
    }

    /**
     * 队列是否满了
     * @return whether is full or not
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 队列是否为空
     * @return whether is empty or not
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 向队列中添加元素
     * @param item 数据元素
     */
    public void add(T item) {
        if(isFull()) {
            throw new ItemFullException();
        }

        this.data[++rear] = item;
    }

    /**
     * 出队列
     * @return 元素
     */
    public T get() {
        if(isEmpty()) {
            throw new RuntimeException("queue is empty");
        }

        return this.data[++this.front];
    }
}
