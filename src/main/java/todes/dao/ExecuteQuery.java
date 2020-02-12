package todes.dao;

import org.hibernate.Session;
import todes.model.Resume;
import todes.query.builder.QueryInfo;
import todes.query.builder.impl.SQLParam;
import todes.query.builder.impl.SQLQueryGenerator;
import todes.query.whereBlock.SQLExpressionGenerator;
import todes.utils.HibernateUtil;

import javax.persistence.Query;
import java.util.List;

public class ExecuteQuery {

    public List firstTest(SQLParam param1, SQLParam param2, SQLParam param3) {
        SQLQueryGenerator queryGenerator = new SQLQueryGenerator();
        SQLExpressionGenerator expGen = new SQLExpressionGenerator();
        QueryInfo queryInfo =
                queryGenerator.select()
                        .from(Resume.class)
                        .where(
                                expGen.and(
                                        expGen.and(expGen.equal(param1), expGen.equal(param2)),
                                        expGen.equal(param3)))
                        .build();
        String generatedQuery = queryInfo.getQuery();
        List<SQLParam> queryParameters = queryInfo.getQueryParameters();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createNativeQuery(generatedQuery, Resume.class);
        System.out.println("Generated query : " + generatedQuery);
        System.out.println("Generated query params : " + queryParameters);
        return query.getResultList();
    }

    public List secondTest(SQLParam param1, SQLParam param2) {
        SQLQueryGenerator queryGenerator = new SQLQueryGenerator();
        SQLExpressionGenerator expGen = new SQLExpressionGenerator();
        QueryInfo queryInfo = queryGenerator.select()
                .from(Resume.class)
                .where(
                        expGen.or(expGen.like(param1), expGen.equal(param2))
                )
                .build();

        String generatedQuery = queryInfo.getQuery();
        List<SQLParam> queryParameters = queryInfo.getQueryParameters();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createNativeQuery(generatedQuery, Resume.class);
        System.out.println("Generated query : " + generatedQuery);
        System.out.println("Generated query params : " + queryParameters);
        return query.getResultList();
    }
}
