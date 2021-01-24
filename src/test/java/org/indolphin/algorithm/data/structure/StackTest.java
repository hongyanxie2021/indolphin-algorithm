package org.indolphin.algorithm.data.structure;

import org.junit.Test;

/**
 * 栈测试
 */
public class StackTest {

    @Test
    public void test() {
        ArrayStack<Integer> stack = new ArrayStack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.list();
    }
}
