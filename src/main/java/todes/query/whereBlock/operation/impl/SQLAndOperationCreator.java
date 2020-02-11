package todes.query.whereBlock.operation.impl;

import todes.query.whereBlock.operation.AndOperationCreator;

public class SQLAndOperationCreator extends SQLBinaryOperationCreator implements AndOperationCreator {

    private String operand = " AND ";

    @Override
    public String create(String leftParam, String rightParam) {
        return create(leftParam, rightParam, operand);
    }

}
