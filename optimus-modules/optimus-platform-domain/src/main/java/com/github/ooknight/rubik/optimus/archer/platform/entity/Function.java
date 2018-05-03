package com.github.ooknight.rubik.optimus.archer.platform.entity;

import com.github.ooknight.rubik.core.entity.UEntity;
import com.github.ooknight.rubik.optimus.archer.platform.enums.DisplayMode;

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
@Table(name = "e_platform_function")
public class Function extends UEntity {

    @Column(name = "name_")
    @JSONField(ordinal = 101)
    private String name;
    @Column(name = "code_")
    @JSONField(ordinal = 102)
    private String code;
    @ManyToOne
    @JoinColumn(name = "module_id_")
    @JSONField(ordinal = 103)
    private Module module;
    @ManyToOne
    @JoinColumn(name = "parent_")
    @JSONField(ordinal = 104)
    private Function parent;
    @Column(name = "url_")
    @JSONField(ordinal = 105)
    private String url;
    @Column(name = "icon_")
    @JSONField(ordinal = 106)
    private String icon;
    @Column(name = "type_")
    @JSONField(ordinal = 107)
    private String type;
    @Column(name = "display_")
    @JSONField(ordinal = 108)
    private DisplayMode display;
    @Column(name = "is_lock_")
    @JSONField(ordinal = 109)
    private Integer isLock;
    @Column(name = "ordinal_")
    @JSONField(ordinal = 110)
    private Integer ordinal;
}
