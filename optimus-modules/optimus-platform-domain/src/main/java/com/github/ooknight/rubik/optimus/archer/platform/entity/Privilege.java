package com.github.ooknight.rubik.optimus.archer.platform.entity;

import com.github.ooknight.rubik.core.entity.UEntity;

import com.alibaba.fastjson.annotation.JSONField;
import io.ebean.annotation.DbJson;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "e_platform_privilege")
public class Privilege extends UEntity {

    @ManyToOne
    @JoinColumn(name = "group_id_")
    @JSONField(ordinal = 101)
    private Group group;
    @ManyToOne
    @JoinColumn(name = "role_id_")
    @JSONField(ordinal = 102)
    private Role role;
    @Column(name = "entity_")
    @JSONField(ordinal = 103)
    private Class entity;
    @Column(name = "field_")
    @JSONField(ordinal = 104)
    private String field;
    @Column(name = "operator_")
    @JSONField(ordinal = 105)
    private String operator;
    @Column(name = "value_")
    @JSONField(ordinal = 106)
    private String value;
    @DbJson
    @Column(name = "restricted_")
    @JSONField(ordinal = 107)
    private Set<String> restricted;
}
