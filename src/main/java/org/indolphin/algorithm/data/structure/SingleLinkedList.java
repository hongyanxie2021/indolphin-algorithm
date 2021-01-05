package org.indolphin.algorithm.data.structure;

import java.security.PublicKey;

/**
 * 单链表
 * @author hongyan
 */
public class SingleLinkedList {

    /**
     * 先初始化一个头结点，头结点固定不动
     */
    private LinkedNode header;

    public SingleLinkedList() {
        // 初始化头结点，头结点为空
        this.header = new LinkedNode(null, null,null);
    }

    /**
     * insert new node into linked list
     * @param node new node
     */
    public void add(LinkedNode node) {
        LinkedNode temp = header;
        while (temp.next != null) {
            // 循环结束时，temp指向链表的最后一个节点
            temp = temp.next;
        }

        temp.next = node;
    }

    /**
     * add new node according to order
     * @param node new node
     */
    public void addByOrder(LinkedNode node) {
        LinkedNode temp = header;
        boolean flag = false;
        while (temp.next != null) {
            if(temp.next.id > node.id) {
                break;
            } else if(temp.next.id.equals(node.id)) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag) {
            throw new RuntimeException("队列中已存在");
        } else {
            node.next = temp.next;
            temp.next = node;
        }
    }

    /**
     * 更新节点
     * @param node 要更新的节点
     */
    public void update(LinkedNode node) {
        if(header.next == null) {
            return;
        }
        LinkedNode temp = header.next;
        boolean flag = false;
        while (temp != null) {
            if(temp.id.equals(node.id)) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag) {
            temp.name = node.name;
        } else {
            throw new RuntimeException("队列中不存在该节点");
        }
    }

    /**
     * delete specific node
     * @param node node needed to be deleted
     */
    public void delete(LinkedNode node) {
        LinkedNode temp = header;
        boolean flag = false;
        while (temp.next != null) {
            if(temp.next.id == node.id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag) {
            temp.next = temp.next.next;
        } else {
            throw new RuntimeException("队列中不存在该节点");
        }
    }

    /**
     * show the data info in current linked list
     */
    public void list() {
        LinkedNode temp = header.next;
        while (temp != null) {
            System.out.println(temp.id + " " + temp.name);
            temp = temp.next;
        }
        System.out.println("-------------------------------");
    }
}
