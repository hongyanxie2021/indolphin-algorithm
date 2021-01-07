package org.indolphin.algorithm.data.structure;

import org.junit.Test;

import java.util.LinkedList;

public class SingleLinkedListTest {

    @Test
    public void test() {
        SingleLinkedList linkedList = new SingleLinkedList();
        LinkedNode node1 = new LinkedNode(1, "",null);
        LinkedNode node2 = new LinkedNode(2, "",null);
        LinkedNode node3 = new LinkedNode(3, "",null);
        LinkedNode node4 = new LinkedNode(4, "",null);
        LinkedNode node5 = new LinkedNode(5, "",null);
        LinkedNode node6 = new LinkedNode(10, "",null);
        LinkedNode node7 = new LinkedNode(8, "",null);
        LinkedNode node8 = new LinkedNode(6, "",null);
        LinkedNode node9 = new LinkedNode(2, "",null);
        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node3);
        linkedList.add(node4);
        linkedList.add(node5);
        /**
         * test function addByOrder
         */
        linkedList.addByOrder(node6);
        linkedList.addByOrder(node7);
        linkedList.addByOrder(node8);
        linkedList.list();
        linkedList.update(new LinkedNode(5, "石破天", null));
        linkedList.list();

        linkedList.delete(new LinkedNode(1, "", null));
        linkedList.list();

/*        linkedList.reverse();
        linkedList.list();*/
        linkedList.reversePrint();
        linkedList.list();
        //linkedList.addByOrder(node9);

    }
}
