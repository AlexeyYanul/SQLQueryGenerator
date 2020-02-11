package todes.query.clause.impl;

import todes.query.clause.WhereClauseCreator;
import todes.query.whereBlock.ExpressionGenerator;

public class SQLWhereClauseCreator implements WhereClauseCreator {

    private String expression = " WHERE ";

    @Override
    public String create(ExpressionGenerator expressionGenerator) {
        return expression + expressionGenerator.getLine();
    }

}
