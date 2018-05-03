package com.github.ooknight.rubik.core.session;

import io.ebean.annotation.EnumValue;

public enum AccountType {
    //
    @EnumValue("1") NORMAL,
    @EnumValue("8") ADMIN,
    @EnumValue("9") GOD
}
