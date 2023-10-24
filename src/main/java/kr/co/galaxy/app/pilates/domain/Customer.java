package kr.co.galaxy.app.pilates.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Getter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    private String name;
    private String sex;
    private Date dateOfBirth;
    private String status;
    private boolean isDeleted;

    public Customer(String name, String sex, Date dateOfBirth) {
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
    }

    protected Customer() {

    }
}
