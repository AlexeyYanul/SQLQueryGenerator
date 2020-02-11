package todes.query.clause.impl;

import todes.query.clause.FromClauseCreator;

import javax.persistence.Entity;
import java.lang.annotation.Annotation;

public class SQLFromClauseCreator implements FromClauseCreator {

    private String expression = " FROM ";

    @Override
    public String create(Class aClass) {
        Annotation annotation = aClass.getAnnotation(Entity.class);
        Entity entity = (Entity) annotation;
        String name = entity.name();
        return expression + name;
    }

}
