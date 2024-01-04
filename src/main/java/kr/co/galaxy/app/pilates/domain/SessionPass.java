package kr.co.galaxy.app.pilates.domain;

import jakarta.persistence.*;
import kr.co.galaxy.app.pilates.common.AuditEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SessionPass extends AuditEntity {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "COUNT")
    private int count;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    public SessionPass(String type, int count, Customer customer) {
        this.type = type;
        this.count = count;
        this.customer = customer;
    }

    public void use() {
        this.count--;
    }

    public void update(int count) {
        this.count = count;
    }




}
