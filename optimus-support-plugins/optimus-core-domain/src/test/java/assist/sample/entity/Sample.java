package assist.sample.entity;

import com.github.ooknight.rubik.core.entity.UEntity;

import com.alibaba.fastjson.annotation.JSONField;
import io.ebean.annotation.Encrypted;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "e_sample")
public class Sample extends UEntity {

    @Column(name = "name_")
    @JSONField(ordinal = 101)
    private String name;
    //
    @Column(name = "mail_")
    @JSONField(ordinal = 102)
    @Encrypted(dbEncryption = false)
    private String mail;
}
