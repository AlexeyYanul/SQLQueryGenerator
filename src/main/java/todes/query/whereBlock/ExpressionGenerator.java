package todes.query.whereBlock;

import todes.query.builder.impl.SQLParam;
import todes.query.whereBlock.expression.ExpressionCreator;

import java.util.List;

public interface ExpressionGenerator<T> {

    T and(ExpressionGenerator leftExpression, ExpressionGenerator rightParam);

    T or(ExpressionGenerator leftExpression, ExpressionGenerator rightParam);

    T like(SQLParam param);

    T equal(SQLParam param);

    String getLine();

    List<SQLParam> getParams();

}
