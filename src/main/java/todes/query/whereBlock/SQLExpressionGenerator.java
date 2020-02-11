package todes.query.whereBlock;

import todes.query.builder.impl.SQLParam;
import todes.query.whereBlock.expression.EqualExpressionCreator;
import todes.query.whereBlock.expression.LikeExpressionCreator;
import todes.query.whereBlock.expression.impl.SQLEqualExpressionCreator;
import todes.query.whereBlock.expression.impl.SQLLikeExpressionCreator;
import todes.query.whereBlock.operation.AndOperationCreator;
import todes.query.whereBlock.operation.OrOperationCreator;
import todes.query.whereBlock.operation.impl.SQLAndOperationCreator;
import todes.query.whereBlock.operation.impl.SQLOrOperationCreator;

import java.util.ArrayList;
import java.util.List;

public class SQLExpressionGenerator implements ExpressionGenerator<SQLExpressionGenerator> {

    private StringBuilder line = new StringBuilder();
    private List<SQLParam> params = new ArrayList<>();

    private AndOperationCreator andOperationCreator;
    private OrOperationCreator orOperationCreator;
    private LikeExpressionCreator likeExpressionCreator;
    private EqualExpressionCreator equalExpressionCreator;

    public SQLExpressionGenerator() {
        this.andOperationCreator = new SQLAndOperationCreator();
        this.orOperationCreator = new SQLOrOperationCreator();
        this.likeExpressionCreator = new SQLLikeExpressionCreator();
        this.equalExpressionCreator = new SQLEqualExpressionCreator();
    }

    @Override
    public SQLExpressionGenerator and(ExpressionGenerator leftExp, ExpressionGenerator rightExp) {
        SQLExpressionGenerator generator = new SQLExpressionGenerator();
        String leftExpLine = leftExp.getLine();
        String rightExpLine = rightExp.getLine();
        generator.line.append(andOperationCreator.create(leftExpLine, rightExpLine));
        generator.params.addAll(leftExp.getParams());
        generator.params.addAll(rightExp.getParams());
        return generator;
    }

    @Override
    public SQLExpressionGenerator or(ExpressionGenerator leftExp, ExpressionGenerator rightExp) {
        SQLExpressionGenerator generator = new SQLExpressionGenerator();
        String leftExpLine = leftExp.getLine();
        String rightExpLine = rightExp.getLine();
        generator.line.append(orOperationCreator.create(leftExpLine, rightExpLine));
        generator.params.addAll(leftExp.getParams());
        generator.params.addAll(rightExp.getParams());
        return generator;
    }

    @Override
    public SQLExpressionGenerator like(SQLParam param) {
        SQLExpressionGenerator generator = new SQLExpressionGenerator();
        generator.params.add(param);
        generator.line.append(likeExpressionCreator.createExpression(param));
        return generator;
    }

    @Override
    public SQLExpressionGenerator equal(SQLParam param) {
        SQLExpressionGenerator generator = new SQLExpressionGenerator();
        generator.params.add(param);
        generator.line.append(equalExpressionCreator.createExpression(param));
        return generator;
    }

    public String getLine() {
        return line.toString();
    }

    public List<SQLParam> getParams() {
        return params;
    }

    public AndOperationCreator getAndOperationCreator() {
        return andOperationCreator;
    }

    public void setAndOperationCreator(AndOperationCreator andOperationCreator) {
        this.andOperationCreator = andOperationCreator;
    }

    public OrOperationCreator getOrOperationCreator() {
        return orOperationCreator;
    }

    public void setOrOperationCreator(OrOperationCreator orOperationCreator) {
        this.orOperationCreator = orOperationCreator;
    }

    public LikeExpressionCreator getLikeExpressionCreator() {
        return likeExpressionCreator;
    }

    public void setLikeExpressionCreator(LikeExpressionCreator likeExpressionCreator) {
        this.likeExpressionCreator = likeExpressionCreator;
    }

    public EqualExpressionCreator getEqualExpressionCreator() {
        return equalExpressionCreator;
    }

    public void setEqualExpressionCreator(EqualExpressionCreator equalExpressionCreator) {
        this.equalExpressionCreator = equalExpressionCreator;
    }
}
