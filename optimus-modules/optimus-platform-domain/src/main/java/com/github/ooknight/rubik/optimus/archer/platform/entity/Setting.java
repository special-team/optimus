package com.github.ooknight.rubik.optimus.archer.platform.entity;

import com.github.ooknight.rubik.core.entity.UEntity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "e_platform_setting")
public class Setting extends UEntity {

    @Column(name = "config_key_")
    @JSONField(ordinal = 101)
    @Enumerated(EnumType.STRING)
    private KEY configKey;
    @Column(name = "config_value_")
    @JSONField(ordinal = 102)
    private String configValue;

    public enum KEY {
        ACCOUNT_DEFAULT_PASSWORD
    }
}
