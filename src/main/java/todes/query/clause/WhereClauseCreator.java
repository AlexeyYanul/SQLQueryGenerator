package todes.query.clause;

import todes.query.whereBlock.ExpressionGenerator;

public interface WhereClauseCreator {
    String create(ExpressionGenerator expressionGenerator);

}
