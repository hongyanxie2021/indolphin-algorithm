package org.indolphin.algorithm.data.structure;

/**
 * 单链表
 * @author hongyan
 */
public class SingleLinkedList<T> {

    /**
     * 先初始化一个头结点，头结点固定不动
     */
    private LinkedNode<T> header;

    public SingleLinkedList() {
        // 初始化头结点，头结点为空
        this.header = new LinkedNode<>(null, null);
    }

    /**
     * insert new node into linked list
     * @param node new node
     */
    public void add(LinkedNode<T> node) {
        LinkedNode temp = header;
        while (temp.next != null) {
            // 循环结束时，temp指向链表的最后一个节点
            temp = temp.next;
        }

        temp.next = node;
    }

    /**
     * show the data info in current linked list
     */
    public void list() {
        LinkedNode<T> temp = header.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
}
