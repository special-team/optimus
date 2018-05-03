package com.github.ooknight.rubik.support.thymeleaf.dialect;

import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionObjectDialect;
import org.thymeleaf.expression.IExpressionObjectFactory;

public class RubikDialect extends AbstractDialect implements IExpressionObjectDialect {

    private final IExpressionObjectFactory RUBIK_EXPRESSION_OBJECTS_FACTORY = new RubikExpressionObjectFactory();

    public RubikDialect() {
        //noinspection ObviousNullCheck
        super("rubik");
    }

    @Override
    public IExpressionObjectFactory getExpressionObjectFactory() {
        return RUBIK_EXPRESSION_OBJECTS_FACTORY;
    }
}
