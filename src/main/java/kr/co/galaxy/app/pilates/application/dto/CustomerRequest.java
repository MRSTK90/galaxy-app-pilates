package kr.co.galaxy.app.pilates.application.dto;

import kr.co.galaxy.app.pilates.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    private String name;
    private String sex;
    private LocalDate dateOfBirth;

    public Customer toCustomer(){
        return new Customer(name, sex, dateOfBirth);
    }
}
