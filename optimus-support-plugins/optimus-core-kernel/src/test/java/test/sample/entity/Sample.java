package test.sample.entity;

import com.github.ooknight.rubik.core.entity.UEntity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Getter
@Setter
@Entity
@Table(name = "e_sample")
@UniqueConstraint(columnNames = {"first_name_", "last_name_"})
public class Sample extends UEntity {

    @Column(name = "first_name_")
    @JSONField(ordinal = 101)
    private String firstName;
    @Column(name = "last_name_")
    @JSONField(ordinal = 102)
    private String lastName;
    @Column(name = "mail_")
    @JSONField(ordinal = 103)
    private String mail;
}
