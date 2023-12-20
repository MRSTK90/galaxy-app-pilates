package kr.co.galaxy.app.pilates.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
public class Customer {

    @Id
    @UuidGenerator
    @Column(name = "ID", columnDefinition = "BINARY(16)")
    private UUID id;
    private String name;
    private String sex;
    private LocalDate dateOfBirth;
    private String status;
    private boolean isDeleted;

    public Customer(String name, String sex, LocalDate dateOfBirth) {
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
    }

    protected Customer() {

    }
}
