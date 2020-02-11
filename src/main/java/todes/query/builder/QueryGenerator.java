package todes.query.builder;

import todes.query.whereBlock.ExpressionGenerator;

public interface QueryGenerator<T> {

    T select();

    T from(Class aClass);

    T where(ExpressionGenerator expressionCreator);

    QueryInfo build();
}
