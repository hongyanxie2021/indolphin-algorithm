package org.indolphin.algorithm;

import org.junit.Test;

import java.util.List;

public class CalculatorTest {

    @Test
    public void test() {
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate("3+6*2-7"));
        System.out.println(calculator.calculate("23+6*12-7"));
        System.out.println(calculator.calculate("7*2*2-5+1-5+3-4"));
    }

    @Test
    public void reversePolishNotationTest() {
        ReversePolishNotationCalculator calculator = new ReversePolishNotationCalculator();
        int result = calculator.calculate("1+((12+3)*4)-15");
        System.out.println(result);
    }

    @Test
    public void expressionToList() {
        ReversePolishNotationCalculator calculator = new ReversePolishNotationCalculator();
        List<String> list = calculator.convertExpressionToList("1+((12+3)*4)-51");
        for(String num : list) {
            System.out.println(num);
        }
    }
}
