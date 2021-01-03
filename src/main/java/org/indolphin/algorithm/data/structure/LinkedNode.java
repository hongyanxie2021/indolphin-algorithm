package org.indolphin.algorithm.data.structure;

/**
 * 链表节点
 * @author hongyan
 * @param <T> 泛型
 */
public class LinkedNode<T> {

    /**
     * 保存节点数据
     */
    private T data;

    /**
     * 保存下一个节点
     */
    public LinkedNode next;

    public LinkedNode(T data, LinkedNode node) {
        this.data = data;
        this.next = node;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
