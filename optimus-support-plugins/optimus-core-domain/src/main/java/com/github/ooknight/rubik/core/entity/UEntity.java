package com.github.ooknight.rubik.core.entity;

import optimus.TOOLKIT;

import com.alibaba.fastjson.annotation.JSONField;
import io.ebean.annotation.CreatedTimestamp;
import io.ebean.annotation.SoftDelete;
import io.ebean.annotation.UpdatedTimestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class UEntity implements Serializable {

    @Id
    @Column(name = "id_")
    @JSONField(ordinal = 1)
    private Long id;
    @SoftDelete
    @Column(name = "deleted_", updatable = false)
    @JSONField(ordinal = 991)
    private boolean deleted;
    @CreatedTimestamp
    @Column(name = "created_")
    @JSONField(ordinal = 992)
    private LocalDateTime created;
    @UpdatedTimestamp
    @Column(name = "updated_")
    @JSONField(ordinal = 993)
    private LocalDateTime updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public Active active() {
        return this.deleted ? Active.DISABLED : Active.ENABLED;
    }

    @Override
    public String toString() {
        return TOOLKIT.TO_JSON_STRING(this);
    }
}
