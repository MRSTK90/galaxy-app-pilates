package kr.co.galaxy.app.pilates.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import kr.co.galaxy.app.pilates.application.dto.CustomerRequest;
import kr.co.galaxy.app.pilates.common.AuditEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer extends AuditEntity {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
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

    public void update(CustomerRequest request){
        this.name = request.getName();
        this.sex = request.getSex();
        this.dateOfBirth = request.getDateOfBirth();
    }

}
