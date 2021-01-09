package org.indolphin.algorithm.data.structure;

/**
 * 双向链表节点类
 * @author hongyan
 */
public class DoubleLinkedNode {

    public int id;
    public String name;
    public DoubleLinkedNode pre;
    public DoubleLinkedNode next;

    public DoubleLinkedNode(int id, String name, DoubleLinkedNode pre, DoubleLinkedNode next) {
        this.id = id;
        this.name = name;
        this.pre = pre;
        this.next = next;
    }

    @Override
    public String toString() {
        return "[ " + id + " " + name + " ]";
    }
}
