package org.indolphin.algorithm.data.structure;

import org.indolphin.algorithm.data.structure.LinkedNode;
import org.indolphin.algorithm.data.structure.SingleLinkedList;
import org.junit.Test;

import java.util.LinkedList;

public class SingleLinkedListTest {

    @Test
    public void test() {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        LinkedNode<Integer> node1 = new LinkedNode<>(1, null);
        LinkedNode<Integer> node2 = new LinkedNode<>(2, null);
        LinkedNode<Integer> node3 = new LinkedNode<>(3, null);
        LinkedNode<Integer> node4 = new LinkedNode<>(4, null);
        LinkedNode<Integer> node5 = new LinkedNode<>(5, null);
        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node3);
        linkedList.add(node4);
        linkedList.add(node5);
        linkedList.list();
    }
}
