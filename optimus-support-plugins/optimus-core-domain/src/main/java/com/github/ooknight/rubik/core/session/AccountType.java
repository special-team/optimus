package com.github.ooknight.rubik.core.session;

import io.ebean.annotation.EnumValue;

public enum AccountType {
    //
    @EnumValue("1") GOD,
    @EnumValue("10") ADMIN,
    @EnumValue("11") NORMAL,
}
