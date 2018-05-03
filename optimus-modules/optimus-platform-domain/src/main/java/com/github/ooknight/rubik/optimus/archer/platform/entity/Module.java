package com.github.ooknight.rubik.optimus.archer.platform.entity;

import com.github.ooknight.rubik.core.entity.UEntity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "e_platform_module")
public class Module extends UEntity {

    @Column(name = "name_")
    @JSONField(ordinal = 101)
    private String name;
    @Column(name = "icon_")
    @JSONField(ordinal = 102)
    private String icon;
    @Column(name = "ordinal_")
    @JSONField(ordinal = 103)
    private Integer ordinal;
    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL)
    @JSONField(ordinal = 104)
    private List<Function> function;
}
