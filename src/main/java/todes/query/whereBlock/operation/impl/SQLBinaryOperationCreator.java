package todes.query.whereBlock.operation.impl;

public class SQLBinaryOperationCreator {

    public String create(String leftParam, String rightParam, String operand) {
        return leftParam + operand + rightParam;
    }
}
