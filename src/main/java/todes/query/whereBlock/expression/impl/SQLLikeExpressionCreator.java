package todes.query.whereBlock.expression.impl;

import todes.query.builder.impl.SQLParam;
import todes.query.whereBlock.expression.LikeExpressionCreator;

public class SQLLikeExpressionCreator extends SQLUnaryExpressionCreator implements LikeExpressionCreator {

    private String operand = " LIKE ";

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
