package org.indolphin.algorithm.data.structure;

/**
 * 基于数组实现Stack
 * @author hongyan
 * @param <E> 泛型
 */
public class ArrayStack<E> {

    private int maxSize;
    private E[] data;
    /**
     * 表示栈顶
     */
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        data = (E[]) new Object[maxSize];
    }

    /**
     * 栈是否已满
     * @return 是否已满
     */
    public boolean isFull() {
        return this.top == this.maxSize - 1;
    }

    /**
     * 栈是否为空
     * @return 是否为空
     */
    public boolean isEmpty() {
        return this.top == -1;
    }

    /**
     * 入栈
     * @param element 入栈元素
     */
    public void push(E element) {
        if(isFull()) {
            throw new RuntimeException("The stack is full");
        }
        this.data[++top] = element;
    }

    /**
     * 出栈
     * @return 栈顶元素
     */
    public E pop() {
        if(isEmpty()) {
            throw new RuntimeException("The stack is empty");
        }
        return this.data[top--];
    }

    /**
     * 遍历栈，从栈顶开始
     */
    public void list() {
        int count = top;
        while (count > -1) {
            System.out.println(this.data[count--]);
        }
    }
}
