package org.indolphin.algorithm.data.structure;

import org.junit.Test;

/**
 * 双向链表测试类
 * @author hongyan
 */
public class DoubleLinkedListTest {

    @Test
    public void addTest() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        DoubleLinkedNode node1 = new DoubleLinkedNode(1, "James", null, null);
        DoubleLinkedNode node2 = new DoubleLinkedNode(2, "Anthony", null, null);
        DoubleLinkedNode node3 = new DoubleLinkedNode(3, "Wade", null, null);
        DoubleLinkedNode node5 = new DoubleLinkedNode(5, "Paul", null, null);

        doubleLinkedList.add(node1);
        doubleLinkedList.add(node2);
        doubleLinkedList.add(node3);
        doubleLinkedList.add(node5);

        doubleLinkedList.list();
        System.out.println("-----------------------------------------------");
        DoubleLinkedNode node = new DoubleLinkedNode(5, "Kris Paul", null, null);
        doubleLinkedList.update(node);
        doubleLinkedList.list();
        System.out.println("-----------------------------------------------");

        doubleLinkedList.delete(node);
        doubleLinkedList.list();
        System.out.println("-----------------------------------------------");

        DoubleLinkedNode node4 = new DoubleLinkedNode(4, "张三", null, null);
        DoubleLinkedNode node6 = new DoubleLinkedNode(6, "李四", null, null);
        doubleLinkedList.addByOrder(node4);
        doubleLinkedList.addByOrder(node6);
        doubleLinkedList.list();
    }
}
