package org.indolphin.algorithm;

import org.junit.Test;

/**
 * 约瑟夫问题测试
 * @author hongyan
 */
public class JosephProblemTest {

    @Test
    public void test() {
        JosephProblem josephProblem = new JosephProblem();
        josephProblem.solve(1,2,25);
    }
}
