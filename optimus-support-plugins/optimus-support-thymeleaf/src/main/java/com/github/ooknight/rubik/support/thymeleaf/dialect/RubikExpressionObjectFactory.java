package com.github.ooknight.rubik.support.thymeleaf.dialect;

import com.github.ooknight.rubik.support.thymeleaf.expression.SessionUserExpression;
import com.github.ooknight.rubik.support.thymeleaf.expression.UserInterfaceExpression;

import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.expression.IExpressionObjectFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class RubikExpressionObjectFactory implements IExpressionObjectFactory {

    private static final String SESSION_USER_EXPRESSION_OBJECT_NAME = "who";
    private static final String DICTIONARY_EXPRESSION_OBJECT_NAME = "dictionary";
    private static final String USER_INTERFACE_EXPRESSION_OBJECT_NAME = "ui";
    ///
    private static final SessionUserExpression SESSION_USER_EXPRESSION = new SessionUserExpression();
    ///
    private static final Set<String> ALL_EXPRESSION_OBJECT_NAMES = Collections.unmodifiableSet(
        new HashSet<>(Arrays.asList(
            SESSION_USER_EXPRESSION_OBJECT_NAME,
            DICTIONARY_EXPRESSION_OBJECT_NAME,
            USER_INTERFACE_EXPRESSION_OBJECT_NAME
        ))
    );

    @Override
    public Set<String> getAllExpressionObjectNames() {
        return ALL_EXPRESSION_OBJECT_NAMES;
    }

    @Override
    public Object buildObject(IExpressionContext context, String name) {
        if (SESSION_USER_EXPRESSION_OBJECT_NAME.equals(name)) {
            return SESSION_USER_EXPRESSION;
        }
        if (USER_INTERFACE_EXPRESSION_OBJECT_NAME.equals(name)) {
            return new UserInterfaceExpression(context);
        }
        return null;
    }

    @Override
    public boolean isCacheable(String expressionObjectName) {
        return true;
    }
}
