package todes.query.builder;

import todes.query.builder.impl.SQLParam;

import java.util.List;

public interface QueryInfo {

    String getQuery();

    List<SQLParam> getQueryParameters();

    void append(String str);

    void addQueryParameter(SQLParam param);

    void addQueryParameters(List<SQLParam> paramList);

}
