package com.github.ooknight.rubik.prototype.authority;

import com.github.ooknight.rubik.support.core.OClass;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

public final class Scope extends OClass {

    private static final Condition ALWAYS_TRUE = new Condition("1", "1");
    private static final Condition ALWAYS_FALSE = new Condition("1", "0");
    //
    private Long uid;
    private Long rid;
    private Long gid;
    private Set<String> restricteds;
    private Map<Class, Condition> conditions;
    private Condition defaultCondition;

    private Scope(Long uid, Long rid, Long gid, Set<String> restricteds, Map<Class, Condition> conditions, boolean supervisor) {
        this.uid = uid;
        this.rid = rid;
        this.gid = gid;
        this.restricteds = (restricteds == null ? Sets.newHashSet() : restricteds);
        this.conditions = (conditions == null ? Maps.newHashMap() : conditions);
        this.defaultCondition = supervisor ? ALWAYS_TRUE : ALWAYS_FALSE;
    }

    public static Scope DUMMY() {
        return new Scope(0L, 0L, 0L, null, null, false);
    }

    public static Scope BUILD(Long uid, Long rid, Long gid, boolean supervisor) {
        return new Scope(uid, rid, gid, null, null, supervisor);
    }

    public static Scope BUILD(Long uid, Long rid, Long gid, Set<String> restricteds, Map<Class, Condition> conditions, boolean supervisor) {
        return new Scope(uid, rid, gid, restricteds, conditions, supervisor);
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

    @JSONField(name = "conditions", ordinal = 5)
    public Map<Class, Condition> expressions() {
        return this.conditions;
    }

    public Condition condition(Class clz) {
        return conditions.getOrDefault(clz, defaultCondition);
    }

    public static class Condition implements Serializable {

        private String left;
        private String right;

        private Condition(String left, String right) {
            this.left = left;
            this.right = right;
        }

        public String raw() {
            return left + "=" + right;
        }
    }
}
