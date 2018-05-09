package com.github.ooknight.rubik.core.session;

import com.github.ooknight.rubik.support.core.OClass;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import io.ebean.Expression;
import io.ebeaninternal.server.expression.DefaultExpressionFactory;

import java.util.Map;
import java.util.Set;

public final class Scope extends OClass {

    private static final DefaultExpressionFactory EXPRESSION_FACTORY = new DefaultExpressionFactory(false, false);
    //
    private static final Expression ALWAYS_TRUE = EXPRESSION_FACTORY.raw("1=1");
    private static final Expression ALWAYS_FALSE = EXPRESSION_FACTORY.raw("1=0");
    //
    private Long uid;
    private Long rid;
    private Long gid;
    private Set<String> restricteds;
    private Map<Class, Expression> expressions;
    private Expression defaultExpression;

    private Scope(Long uid, Long rid, Long gid, Set<String> restricteds, Map<Class, Expression> expressions, boolean supervisor) {
        this.uid = uid;
        this.rid = rid;
        this.gid = gid;
        this.restricteds = (restricteds == null ? Sets.newHashSet() : restricteds);
        this.expressions = (expressions == null ? Maps.newHashMap() : expressions);
        this.defaultExpression = supervisor ? ALWAYS_TRUE : ALWAYS_FALSE;
    }

    public static Scope DUMMY() {
        return new Scope(0L, 0L, 0L, null, null, false);
    }

    public static Scope BUILD(Long uid, Long rid, Long gid, boolean supervisor) {
        return new Scope(uid, rid, gid, null, null, supervisor);
    }

    public static Scope BUILD(Long uid, Long rid, Long gid, Set<String> restricteds, Map<Class, Expression> expressions, boolean supervisor) {
        return new Scope(uid, rid, gid, restricteds, expressions, supervisor);
    }

    @JSONField(name = "uid", ordinal = 1)
    public Long uid() {
        return uid;
    }

    @JSONField(name = "rid", ordinal = 2)
    public Long rid() {
        return rid;
    }

    @JSONField(name = "gid", ordinal = 3)
    public Long gid() {
        return gid;
    }

    @JSONField(name = "restricteds", ordinal = 4)
    public Set<String> restricteds() {
        return this.restricteds;
    }

    @JSONField(name = "expressions", ordinal = 5)
    public Map<Class, Expression> expressions() {
        return this.expressions;
    }

    public Expression expression(Class clz) {
        return expressions.getOrDefault(clz, defaultExpression);
    }
}
