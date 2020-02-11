package todes.query.whereBlock.operation.impl;

import todes.query.whereBlock.operation.OrOperationCreator;

public class SQLOrOperationCreator extends SQLBinaryOperationCreator implements OrOperationCreator {

    private String operand = " OR ";

    @Override
    public String create(String leftParam, String rightParam) {
        return create(leftParam, rightParam, operand);
    }

}
