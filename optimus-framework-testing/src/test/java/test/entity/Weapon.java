package test.entity;

import io.ebean.annotation.CreatedTimestamp;
import io.ebean.annotation.UpdatedTimestamp;
import lombok.Data;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
public class Weapon {

    @Id
    private Long id;
    private String name;
    @CreatedTimestamp
    private LocalDateTime created;
    @UpdatedTimestamp
    private LocalDateTime updated;
}
