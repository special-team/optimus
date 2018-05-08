package com.github.ooknight.rubik.optimus.archer.platform.entity;

import com.github.ooknight.rubik.core.entity.UEntity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "e_platform_group")
public class Group extends UEntity {

    @Column(name = "name_")
    @JSONField(ordinal = 101)
    private String name;
    @Column(name = "short_name_")
    @JSONField(ordinal = 102)
    private String shortName;
    //@Column(name = "type_")
    //@JSONField(ordinal = 103)
    //private Class<Scope> type;
    @ManyToOne
    @JoinColumn(name = "superior_id_")
    @JSONField(ordinal = 104)
    private Group superior;
}
