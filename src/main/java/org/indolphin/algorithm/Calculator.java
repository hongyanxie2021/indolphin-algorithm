package org.indolphin.algorithm;

/**
 * 基于栈实现计算器
 * 中缀表达式
 * @author hongyan
 */
public class Calculator {

    /**
     * 计算
     * @param expression 计算器表达式
     * @return 结果
     */
    public Double calculate(String expression) {
        // TODO 加小括号
        CalculatorStack<Double> numberStack = new CalculatorStack(10);
        CalculatorStack<Character> operatorStack = new CalculatorStack(10);

        int index = 0;
        char val = ' ';
        // 后出栈数据
        double num1 = 0;
        // 先出栈数据
        double num2 = 0;
        double result = 0.0;
        char operator = ' ';
        while (index < expression.length()) {
            val = expression.charAt(index);
            if(isOperator(val)) {
                if(!operatorStack.isEmpty()) {
                    // 比较优先级
                    if(getPriority(val) <= getPriority(operatorStack.peek())) {
                        num2 = numberStack.pop();
                        num1 = numberStack.pop();
                        operator = operatorStack.pop();
                        result = operatorCalculate(num1, num2, operator);
                        // 运算结果入栈
                        numberStack.push(result);
                        // 当前操作符入符号栈
                        operatorStack.push(val);
                    } else {
                        operatorStack.push(val);
                    }
                } else {
                    // 如果运算符栈为空，则直接入栈
                    operatorStack.push(val);
                }
                index++;
            } else {
/*                numberStack.push((double) (val - 48));
                index++;*/
                int begin = index;
                while (index < expression.length() && !isOperator(expression.charAt(index))) {
                    index++;
                }
                numberStack.push(Double.parseDouble(expression.substring(begin,index)));
            }

        }

        while (!operatorStack.isEmpty()) {
            num2 = numberStack.pop();
            num1 = numberStack.pop();
            operator = operatorStack.pop();
            result = operatorCalculate(num1, num2, operator);
            // 运算结果入栈
            numberStack.push(result);
        }
        return numberStack.peek();
    }

    /**
     * 计算
     * @param num1 后出栈数
     * @param num2 先出栈数
     * @param operator 运算符
     * @return 结果
     */
    private double operatorCalculate(double num1, double num2, char operator) {
        double result = 0.0;
        switch (operator) {
            case '*':
                result = num1 * num2;
                break;
            case  '/':
                result = num1 / num2;
                break;
            case  '+':
                result = num1 + num2;
                break;
            case  '-':
                result = num1 - num2;
                break;
            default:
                break;
        }
        return result;
    }

    /**
     * 判断是否为一个运算符
     * @param val 值
     * @return 是否为一个运算符
     */
    private boolean isOperator(char val) {
        return val == '*' || val == '/' || val == '+' || val == '-';
    }

    /**
     * 获取运算符优先级
     * @param operator 操作符
     * @return 优先级
     */
    private int getPriority(int operator) {
        if(operator == '*' || operator == '/') {
            return 1;
        } else if(operator == '+' || operator == '-') {
            return 0;
        } else {
            throw new RuntimeException("Unsupported Operator");
        }
    }
}

/**
 * 计算器栈
 */
class CalculatorStack<E> {

    private int maxSize;
    private E[] data;
    /**
     * 表示栈顶
     */
    private int top = -1;

    public CalculatorStack(int maxSize) {
        this.maxSize = maxSize;
        data = (E[]) new Object[maxSize];
    }

    /**
     * 栈是否已满
     * @return 是否已满
     */
    public boolean isFull() {
        return this.top == this.maxSize - 1;
    }

    /**
     * 栈是否为空
     * @return 是否为空
     */
    public boolean isEmpty() {
        return this.top == -1;
    }

    /**
     * 入栈
     * @param element 入栈元素
     */
    public void push(E element) {
        if(isFull()) {
            throw new RuntimeException("The stack is full");
        }
        this.data[++top] = element;
    }

    /**
     * 出栈
     * @return 栈顶元素
     */
    public E pop() {
        if(isEmpty()) {
            throw new RuntimeException("The stack is empty");
        }
        return this.data[top--];
    }

    /**
     * 遍历栈，从栈顶开始
     */
    public void list() {
        int count = top;
        while (count > -1) {
            System.out.println(this.data[count--]);
        }
    }

    public E peek() {
        return this.data[top];
    }
}
