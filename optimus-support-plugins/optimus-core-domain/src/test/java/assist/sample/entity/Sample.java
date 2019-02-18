package assist.sample.entity;

import com.github.ooknight.rubik.core.entity.UEntity;
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
    private String name;
    //
    @Encrypted(dbEncryption = false)
    @Column(name = "mail_")
    private String mail;
}
