package org.indolphin.algorithm.data.structure;

/**
 * 双向链表
 * @author hongyan
 */
public class DoubleLinkedList {

    private DoubleLinkedNode header = new DoubleLinkedNode(0, null, null, null);

    public DoubleLinkedNode getHeader() {
        return this.header;
    }

    /**
     * 在链表最后添加节点
     * @param node 节点
     */
    public void add(DoubleLinkedNode node) {
        DoubleLinkedNode temp = header;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    /**
     * 更新链表中节点
     * @param node 待更新节点
     */
    public void update(DoubleLinkedNode node) {

        DoubleLinkedNode temp = header.next;
        boolean flag = false;
        while (temp != null) {
            if(temp.id == node.id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag) {
            temp.name = node.name;
        } else {
            throw new RuntimeException("链表中不存在该节点");
        }
    }

    /**
     * 删除双向链表中的节点
     * @param node 节点
     */
    public void delete(DoubleLinkedNode node) {

        DoubleLinkedNode temp = header.next;
        boolean flag = false;
        while (temp != null) {
            if(temp.id == node.id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag) {
            temp.pre.next = temp.next;
            if(temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            throw new RuntimeException("链表中不存在该节点");
        }
    }

    /**
     * 按顺序添加节点
     * @param node 待添加节点
     */
    public void addByOrder(DoubleLinkedNode node) {
        DoubleLinkedNode temp = header;
        boolean flag = false;
        while (temp.next != null) {
            if(node.id < temp.next.id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag || temp.next == null) {
            // 在temp节点之前添加node
            if(temp.next != null) {
                temp.next.pre = node;
                node.next = temp.next;
            }
            temp.next = node;
            node.pre = temp;
        } else {
            throw new RuntimeException("链表中已存在");
        }
    }

    /**
     * 列出双向链表所有节点
     */
    public void list() {

        DoubleLinkedNode temp = header.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
}
