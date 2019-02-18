package com.github.ooknight.rubik.prototype.authority;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Set;

public interface SessionUser extends Serializable {

    /*
    //String TAG_ADMIN = "admin";
    //String SESSION_PARAMETER_NAME = "who";
    */

    @JSONField(name = "uid", ordinal = 1)
    Long uid();

    @JSONField(name = "rid", ordinal = 2)
    Long rid();

    @JSONField(name = "gid", ordinal = 3)
    Long gid();

    @JSONField(name = "name", ordinal = 4)
    String name();

    @JSONField(name = "god", ordinal = 5)
    SessionUserType type();

    @JSONField(name = "resources", ordinal = 6)
    Set<String> resources();

    @JSONField(name = "tags", ordinal = 7)
    Set<String> tags();

    @JSONField(name = "scope", ordinal = 8)
    Scope scope();
}
