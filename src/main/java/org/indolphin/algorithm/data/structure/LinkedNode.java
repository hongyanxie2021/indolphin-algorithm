package org.indolphin.algorithm.data.structure;


/**
 * 链表节点
 * @author hongyan
 */
public class LinkedNode {

    /**
     * 保存节点数据
     */
    public Integer data;

    /**
     * 保存下一个节点
     */
    public LinkedNode next;

    public LinkedNode(Integer data, LinkedNode node) {
        this.data = data;
        this.next = node;
    }

}
