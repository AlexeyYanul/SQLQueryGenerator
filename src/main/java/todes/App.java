package todes;

import todes.model.Resume;
import todes.model.enums.Gender;
import todes.query.builder.QueryInfo;
import todes.query.builder.impl.SQLParam;
import todes.query.builder.impl.SQLQueryGenerator;
import todes.query.whereBlock.SQLExpressionGenerator;

import java.util.List;

public class App {

    public static void main(String[] args) {

        SQLParam likeParam = new SQLParam();
        likeParam.setKey("surname");
        likeParam.setValue("%ов");

        SQLParam equalParam = new SQLParam();
        equalParam.setKey("gender");
        equalParam.setValue(Gender.женщина.toString());

        SQLParam param3 = new SQLParam();
        param3.setKey("QQQ");
        param3.setValue("ZZZ");


        SQLQueryGenerator queryGenerator = new SQLQueryGenerator();
        SQLExpressionGenerator expGen = new SQLExpressionGenerator();
        QueryInfo queryInfo =
                queryGenerator.select()
                        .from(Resume.class)
                        .where(expGen.or(expGen.and(expGen.equal(equalParam), expGen.like(likeParam)), expGen.equal(param3)))
                        .build();
        String generatedQuery = queryInfo.getQuery();
        List<SQLParam> queryParameters = queryInfo.getQueryParameters();
        System.out.println(generatedQuery);
        System.out.println(queryParameters);


    }
}
