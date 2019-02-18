package com.github.ooknight.rubik.prime;

import optimus.TOOLKIT;

import java.io.Serializable;

public abstract class OClass implements Serializable {

    @Override
    public String toString() {
        return TOOLKIT.TO_JSON_STRING(this);
    }
}
