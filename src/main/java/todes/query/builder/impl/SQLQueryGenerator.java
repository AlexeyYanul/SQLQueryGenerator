package todes.query.builder.impl;

import todes.query.builder.QueryGenerator;
import todes.query.builder.QueryInfo;
import todes.query.clause.FromClauseCreator;
import todes.query.clause.SelectClauseCreator;
import todes.query.clause.WhereClauseCreator;
import todes.query.clause.impl.SQLFromClauseCreator;
import todes.query.clause.impl.SQLSelectClauseCreator;
import todes.query.clause.impl.SQLWhereClauseCreator;
import todes.query.whereBlock.ExpressionGenerator;
import todes.query.whereBlock.SQLExpressionGenerator;

public class SQLQueryGenerator implements QueryGenerator<SQLQueryGenerator> {

    private SelectClauseCreator selectClauseCreator;
    private FromClauseCreator fromClauseCreator;
    private WhereClauseCreator whereClauseCreator;
    private ExpressionGenerator expressionGenerator;
    private QueryInfo queryInfo;

    public SQLQueryGenerator() {
        selectClauseCreator = new SQLSelectClauseCreator();
        fromClauseCreator = new SQLFromClauseCreator();
        whereClauseCreator = new SQLWhereClauseCreator();
        expressionGenerator = new SQLExpressionGenerator();
        queryInfo = new SQLQueryInfo();
    }

    @Override
    public SQLQueryGenerator select() {
        queryInfo.append(selectClauseCreator.create());
        return this;
    }

    @Override
    public SQLQueryGenerator from(Class aClass) {
        queryInfo.append(fromClauseCreator.create(aClass));
        return this;
    }

    @Override
    public SQLQueryGenerator where(ExpressionGenerator expressionGenerator) {
        queryInfo.append(whereClauseCreator.create(expressionGenerator));
        queryInfo.addQueryParameters(expressionGenerator.getParams());
        return this;
    }

    @Override
    public QueryInfo build() {
        return queryInfo;
    }


    public SelectClauseCreator getSelectClauseCreator() {
        return selectClauseCreator;
    }

    public void setSelectClauseCreator(SelectClauseCreator selectClauseCreator) {
        this.selectClauseCreator = selectClauseCreator;
    }

    public FromClauseCreator getFromClauseCreator() {
        return fromClauseCreator;
    }

    public void setFromClauseCreator(FromClauseCreator fromClauseCreator) {
        this.fromClauseCreator = fromClauseCreator;
    }

    public WhereClauseCreator getWhereClauseCreator() {
        return whereClauseCreator;
    }

    public void setWhereClauseCreator(WhereClauseCreator whereClauseCreator) {
        this.whereClauseCreator = whereClauseCreator;
    }

    public ExpressionGenerator getExpressionGenerator() {
        return expressionGenerator;
    }

    public void setExpressionGenerator(ExpressionGenerator expressionGenerator) {
        this.expressionGenerator = expressionGenerator;
    }
}
