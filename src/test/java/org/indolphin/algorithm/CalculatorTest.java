package org.indolphin.algorithm;

import org.junit.Test;

public class CalculatorTest {

    @Test
    public void test() {
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate("3+6*2-7"));
        System.out.println(calculator.calculate("23+6*12-7"));
        System.out.println(calculator.calculate("7*2*2-5+1-5+3-4"));
    }
}
