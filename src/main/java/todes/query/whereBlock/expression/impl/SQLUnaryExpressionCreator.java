package todes.query.whereBlock.expression.impl;

import todes.query.builder.impl.SQLParam;

public class SQLUnaryExpressionCreator {

    public String createExpression(SQLParam param, String operand, Boolean hasQuotes) {
        return param.getKey()
                + operand
                + getSpliter(hasQuotes)
                + param.getValue()
                + getSpliter(hasQuotes);
    }

    private String getSpliter(Boolean hasQuotes) {
        return hasQuotes ? "'" : "";
    }
}
