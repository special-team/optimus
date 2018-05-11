package com.github.ooknight.rubik.core.session;

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
    boolean god();

    @JSONField(name = "admin", ordinal = 6)
    boolean admin();

    @JSONField(name = "resources", ordinal = 7)
    Set<String> resources();

    @JSONField(name = "tags", ordinal = 8)
    Set<String> tags();

    @JSONField(name = "scope", ordinal = 9)
    Scope scope();
}
