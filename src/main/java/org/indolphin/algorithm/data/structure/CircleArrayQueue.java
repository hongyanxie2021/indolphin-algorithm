package org.indolphin.algorithm.data.structure;

/**
 * 环形数组模拟队列，是对ArrayQueue的改进
 * @author hongyan
 */
public class CircleArrayQueue<T> {
    /**
     * 实际数据
     */
    private T[] data;

    /**
     * 第一个元素的位置
     */
    private int front;

    /**
     * 最后一个元素的后一个位置
     */
    private int rear;

    /**
     * 数组最大长度
     */
    private int maxSize;

    public CircleArrayQueue(int arrayMaxSize) {
        this.data = (T[]) new Object[arrayMaxSize];
        this.maxSize = arrayMaxSize;
        this.front = 0;
        this.rear = 0;
    }

    /**
     * add new element
     * @param item new element
     */
    public void add(T item) {
        if(isFull()) {
            throw new RuntimeException("队列已满");
        }

        this.data[this.rear] = item;
        this.rear = (this.rear + 1) % this.maxSize;
    }

    /**
     * get queue element
     * @return header element
     */
    public T get() {
        if(isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        T res = this.data[this.front];
        this.front = (this.front + 1) % this.maxSize;
        return res;
    }

    /**
     * 判断队列是否已满
     * @return whether is full or not
     */
    public boolean isFull() {
        return (this.rear + 1) % this.maxSize == this.front;
    }

    /**
     * 判断队列是否为空
     * @return whether is empty or not
     */
    public boolean isEmpty() {
        return this.rear == this.front;
    }

    /**
     * 队列长度
     * @return 队列长度
     */
    public int size() {
        return (this.rear + maxSize - this.front) % this.maxSize;
    }
}
