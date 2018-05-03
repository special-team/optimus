package com.github.ooknight.rubik.core.session;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Set;

@SuppressWarnings("unused")
public interface SessionUser extends Serializable {

    //Integer TYPE_NORMAL = 1;
    //Integer TYPE_ADMIN = 9;
    //
    String TAG_ADMIN = "admin";
    String SESSION_PARAMETER_NAME = "who";

    @JSONField(name = "uid", ordinal = 1)
    Long uid();

    @JSONField(name = "rid", ordinal = 2)
    Long rid();

    @JSONField(name = "gid", ordinal = 3)
    Long gid();

    @JSONField(name = "name", ordinal = 4)
    String name();

    @JSONField(name = "admin", ordinal = 5)
    boolean admin();

    @JSONField(name = "resources", ordinal = 6)
    Set<String> resources();

    @JSONField(name = "tags", ordinal = 7)
    Set<String> tags();

    @JSONField(name = "scope", ordinal = 8)
    Scope scope();
}
