package test.entity;

import io.ebean.annotation.CreatedTimestamp;
import io.ebean.annotation.UpdatedTimestamp;
import lombok.Data;

import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Hero {

    @Id
    private Long id;
    private String name;
    private Weapon left;
    private Weapon right;
    private LocalDate date;
    private LocalDateTime datetime;
    @CreatedTimestamp
    private LocalDateTime created;
    @UpdatedTimestamp
    private LocalDateTime updated;
}
