package com.github.ooknight.rubik.core.entity;

import io.ebean.annotation.EnumValue;

public enum Active implements State {
    //
    @EnumValue("1") ENABLED,
    @EnumValue("0") LOCKED,
    @EnumValue("-1") DISABLED
}
