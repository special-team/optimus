package com.github.ooknight.rubik.core.entity;

import optimus.TOOLKIT;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class OEntity implements Serializable {

    @Override
    public String toString() {
        return TOOLKIT.TO_JSON_STRING(this);
    }
}
