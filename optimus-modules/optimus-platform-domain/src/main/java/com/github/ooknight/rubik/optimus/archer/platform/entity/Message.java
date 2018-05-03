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
@Table(name = "e_platform_message")
public class Message extends UEntity {

    @Column(name = "title_")
    @JSONField(ordinal = 101)
    private String title;
    @Column(name = "content_")
    @JSONField(ordinal = 102)
    private String content;
    @ManyToOne
    @JoinColumn(name = "from_")
    @JSONField(ordinal = 103)
    private Account from;
    @Column(name = "to_")
    @JSONField(ordinal = 104)
    private String to;
}
