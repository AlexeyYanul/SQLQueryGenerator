package todes.query.clause.impl;

import todes.query.clause.SelectClauseCreator;

public class SQLSelectClauseCreator implements SelectClauseCreator {

    private String expression = "SELECT *";

    public String create() {
        return expression;
    }

    /*method create(List<String>)*/

}
