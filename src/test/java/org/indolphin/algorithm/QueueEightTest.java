package org.indolphin.algorithm;

import org.junit.Test;

public class QueueEightTest {

    @Test
    public void test() {
        QueueEight queueEight = new QueueEight();
        queueEight.check(0);
        System.out.println(queueEight.getCount());
    }
}
