package org.indolphin.algorithm;

import java.util.*;

/**
 * 基于逆波兰表达式的计算器
 * @author hongyan
 */
public class ReversePolishNotationCalculator {

    public int calculate(String infixExpression) {
        List<String> suffixList = convertInfixToSuffix(convertExpressionToList(infixExpression));

        return calculateBySuffix(suffixList);
    }



    /**
     * 中缀表达式转后缀表达式
     * @return 后缀表达式List
     */
    public List<String> convertInfixToSuffix(List<String> infix) {
        // 符号栈
        Stack<String> s1 = new Stack<>();
        // 中间结果栈，因为没有出栈操作，可以使用List替代
        List<String> s2 = new ArrayList<>();
        for(String item : infix) {
            if(item.matches("\\d+")) {
                s2.add(item);
            } else if(item.equals("(")) {
                s1.push(item);
            } else if(item.equals(")")) {
                // 如果是右括号")"，则依次弹出s1栈顶的运算符，并压入s2,直到遇到左括号为止，此时将这一对丢弃
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                // 弹出小括号
                s1.pop();
            } else {
                // 当item优先级小于等于s1栈顶优先级，将s1栈顶运算符弹出压入s2，再次与新栈顶优先级比较
                while (s1.size() != 0 && Operation.getPriorityValue(s1.peek()) >= Operation.getPriorityValue(item)) {
                    s2.add(s1.pop());
                }
                s1.add(item);
            }
        }
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;
    }

    /**
     * 将字符串表达式转换为List
     * @return List
     */
    public List<String> convertExpressionToList(String expression) {
        List<String> result = new ArrayList<>();
        int i = 0;
        String number = "";
        while (i<expression.length()) {
            char character = expression.charAt(i);
            if(character >= '0' && character <= '9') {
                number = "";
                while (i < expression.length() && expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                    number += expression.charAt(i);
                    i++;
                }
                result.add(number);
            } else {
                result.add(character + "");
                i++;
            }
        }
        return result;
    }

    public int calculateBySuffix(List<String> suffixList) {

        Stack<String> stack = new Stack<>();
        for(String element : suffixList) {
            if(element.matches("\\d+")) {
                // 如果取出的是数字
                stack.push(element);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if(element.equals("+")) {
                    res = num1 + num2;
                } else if(element.equals("-")) {
                    res = num1 - num2;
                } else if(element.equals("*")) {
                    res = num1 * num2;
                } else if(element.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符异常");
                }
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }

    /**
     * 逆波兰表达式 字符串拆分
     * @param suffixExpression 逆波兰表达式
     * @return 字符串列表
     */
    private List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for(String element : split) {
            list.add(element);
        }
        return list;
    }
}

class Operation {
    private static final int ADD = 1;
    private static final int SUB = 1;
    private static final int MUL = 2;
    private static final int DIV = 2;

    /**
     * 获取操作符优先级
     * @param operation 操作符
     * @return 优先级
     */
    public static int getPriorityValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                break;
        }
        return result;
    }
}
