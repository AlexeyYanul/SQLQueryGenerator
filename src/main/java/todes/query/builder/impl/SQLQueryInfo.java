package todes.query.builder.impl;

import todes.query.builder.QueryInfo;

import java.util.ArrayList;
import java.util.List;

public class SQLQueryInfo implements QueryInfo {

    private StringBuilder stringBuilder = new StringBuilder();
    private List<SQLParam> queryParameters = new ArrayList<>();

    public void append(String str) {
        stringBuilder.append(str);
    }

    @Override
    public String getQuery() {
        return stringBuilder.toString();
    }

    public void addQueryParameter(SQLParam param) {
        queryParameters.add(param);
    }

    public void addQueryParameters(List<SQLParam> paramList) {
        queryParameters.addAll(paramList);
    }

    @Override
    public List<SQLParam> getQueryParameters() {
        return queryParameters;
    }
}
