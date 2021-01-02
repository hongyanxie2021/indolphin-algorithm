package org.indolphin.algorithm.exception;

/**
 * 数据元素满
 * @author hongyan
 */
public class ItemFullException extends RuntimeException {

    private static final String MESSAGE = "element is full";

    public ItemFullException() {
        super(MESSAGE);
    }
}
