package com.github.ooknight.rubik.optimus.archer.platform.entity;

import com.github.ooknight.rubik.core.entity.UEntity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "e_platform_role")
public class Role extends UEntity {

    @Column(name = "name_")
    @JSONField(ordinal = 101)
    private String name;
}
