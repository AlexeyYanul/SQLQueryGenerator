package todes.query.whereBlock.expression.impl;

import todes.query.builder.impl.SQLParam;
import todes.query.whereBlock.expression.EqualExpressionCreator;

public class SQLEqualExpressionCreator extends SQLUnaryExpressionCreator implements EqualExpressionCreator {

    private String operand = " = ";

    private SQLParam param;

    @Override
    public String createExpression(SQLParam param) {
        this.param = param;
        return createExpression(param, operand, true);
    }

    @Override
    public SQLParam getParam() {
        return param;
    }
}
