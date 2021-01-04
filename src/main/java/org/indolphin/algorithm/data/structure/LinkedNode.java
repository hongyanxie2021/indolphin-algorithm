package org.indolphin.algorithm.data.structure;


/**
 * 链表节点
 * @author hongyan
 */
public class LinkedNode {

    /**
     * 保存节点数据
     */
    public Integer id;
    public String name;

    /**
     * 保存下一个节点
     */
    public LinkedNode next;

    public LinkedNode(Integer id, String name, LinkedNode node) {
        this.id = id;
        this.name = name;
        this.next = node;
    }

}
