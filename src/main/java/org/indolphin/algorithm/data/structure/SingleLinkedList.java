package org.indolphin.algorithm.data.structure;

import java.security.PublicKey;
import java.util.Stack;

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
     * 统计链表中节点的数量
     * @return 链表节点数
     */
    public int size() {
        if(header.next == null) {
            return 0;
        }
        LinkedNode temp = header.next;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    /**
     * 获取倒数第index个节点
     * @param index 索引
     * @return 节点
     */
    public LinkedNode findLastIndexOf(int index) {
        if(header.next == null) {
            return null;
        }
        int size = size();
        if(index <=0 || index > size) {
            return null;
        }
        int count = size - index;
        LinkedNode temp = header.next;
        while (count > 0) {
            temp = temp.next;
            count--;
        }
        return temp;
    }

    /**
     * 链表逆转
     * 1、先定义一个节点reverseHeader = new LinkedNode()
     * 2、从头到尾遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHeader的最前端
     * 3、原来的链表header.next = reverseHeader.next
     */
    public void reverse() {
        if(header.next == null || header.next.next == null) {
            // 链表为空或者只有一个节点
            return;
        }
        LinkedNode current = header.next;
        LinkedNode next = null;
        LinkedNode reverseHeader = new LinkedNode(0, null,null);
        while (current != null) {
            // 取出 current.next以备后面使用，防止链表断掉
            next = current.next;
            // 将current放入reverseHeader的后面
            current.next = reverseHeader.next;
            reverseHeader.next = current;
            // current 后移
            current = next;
        }
        header = reverseHeader;
    }

    /**
     * 逆序打印链表节点
     */
    public void reversePrint() {
        if(header.next == null) {
            return;
        }
        Stack<LinkedNode> stack = new Stack<>();
        LinkedNode current = header.next;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        while (!stack.empty()) {
            LinkedNode node = stack.pop();
            System.out.println(node.id + " " + node.name);
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

    /**
     * 合并两个有序链表
     * 思路： 类似链表反转
     * 1、新建一个链表 LinkedNode newHeader = new LinkedNode()
     * 2、比较两个链表的current，较小者放入newHeader链表
     * 3、header = newHeader.next
     * @param otherHeader 另一个链表头节点
     */
    public void merge(LinkedNode otherHeader) {
        // TODO
    }
}
