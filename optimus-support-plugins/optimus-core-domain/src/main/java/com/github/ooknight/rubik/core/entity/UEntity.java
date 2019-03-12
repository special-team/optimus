package com.github.ooknight.rubik.core.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.ebean.annotation.CreatedTimestamp;
import io.ebean.annotation.SoftDelete;
import io.ebean.annotation.UpdatedTimestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class UEntity extends OEntity {

    @Id
    @Column(name = "id_", updatable = false)
    @JSONField
    private Long id;
    //
    @SoftDelete
    @Column(name = "deleted_", updatable = false)
    @JSONField(ordinal = 1000)
    private boolean deleted;
    //
    @CreatedTimestamp
    @Column(name = "created_", updatable = false)
    @JSONField(ordinal = 1001)
    private LocalDateTime created;
    //
    @UpdatedTimestamp
    @Column(name = "updated_")
    @JSONField(ordinal = 1002)
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
}
