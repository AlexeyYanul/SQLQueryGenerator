package todes.query.whereBlock.expression;

import todes.query.builder.impl.SQLParam;

public interface ExpressionCreator {

    String createExpression(SQLParam param);

    SQLParam getParam();

}

