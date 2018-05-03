package com.github.ooknight.rubik.optimus.archer.platform.entity;

import com.github.ooknight.rubik.core.entity.UEntity;
import com.github.ooknight.rubik.core.session.AccountType;

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
@Table(name = "e_platform_account")
public class Account extends UEntity {

    @Column(name = "username_")
    @JSONField(ordinal = 101)
    private String username;
    @Column(name = "password_")
    @JSONField(ordinal = 102)
    private String password;
    @Column(name = "nickname_")
    @JSONField(ordinal = 103)
    private String nickname;
    @Column(name = "certificate_type_")
    @JSONField(ordinal = 104)
    private String certificateType;
    @Column(name = "certificate_number_")
    @JSONField(ordinal = 105)
    private String certificateNumber;
    @Column(name = "mobile_")
    @JSONField(ordinal = 106)
    private String mobile;
    @Column(name = "email_")
    @JSONField(ordinal = 107)
    private String email;
    @ManyToOne
    @JoinColumn(name = "role_id_")
    @JSONField(ordinal = 108)
    private Role role;
    @ManyToOne
    @JoinColumn(name = "group_id_")
    @JSONField(ordinal = 109)
    private Group group;
    @Column(name = "type_")
    @JSONField(ordinal = 110)
    private AccountType type;
    @Column(name = "salt_")
    @JSONField(ordinal = 111)
    private String salt;
}
