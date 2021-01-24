package org.indolphin.algorithm;

/**
 * 单向循环列表解决Joseph问题
 *
 * @author hongyan
 */
public class JosephProblem {

    public void solve(int startNo, int countNum, int n) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.solve(startNo,countNum,n);
    }
}

class CircleSingleLinkedList {
    private Boy first = null;

    public void solve(int startNo, int countNum, int n) {
        if (startNo < 1 || startNo > n) {
            System.out.println("The parameter is wrong");
        }

        // 向链表中添加节点
        add(n);
        // helper初始化为链表最后一个节点
        Boy helper = first;
        while (helper.getNext() != first) {
            helper = helper.getNext();
        }

        for (int i = 1; i < startNo; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        // 这里是一个循环，直到圈中只有一个节点
        while (helper != first) {
            // helper == first 说明链表中只有一个节点
            for (int i = 1; i < countNum; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            // 移除first节点
            System.out.println(first);
            helper.setNext(first.getNext());
            first = first.getNext();
        }
        System.out.println(first);
    }

    /**
     * 向环形链表中添加节点
     *
     * @param num 添加节点数
     */
    private void add(int num) {
        if (num < 1) {
            System.out.println("The value of num is invalid");
            return;
        }
        // 添加创建节点
        Boy current = null;
        for (int i = 1; i <= num; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                current = first;
            } else {
                boy.setNext(first);
                current.setNext(boy);
                current = boy;
            }
        }
    }

    /**
     * 列出环形链表中的节点
     */
    private void list() {
        Boy temp = first;
        while (temp != null && temp.getNext() != first) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }
}

class Boy {
    private int id;
    private Boy next;

    public Boy(int id) {
        this.id = id;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public Boy getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "[ " + this.id + " ]";
    }
}


