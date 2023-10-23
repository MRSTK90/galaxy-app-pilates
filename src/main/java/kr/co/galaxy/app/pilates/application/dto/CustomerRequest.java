package kr.co.galaxy.app.pilates.application.dto;

import kr.co.galaxy.app.pilates.domain.Customer;
import lombok.Getter;

import java.util.Date;

@Getter
public class CustomerRequest {
    private String name;
    private String sex;
    private Date dateOfBirth;

    public Customer toCustomer(){
        return new Customer(name, sex, dateOfBirth);
    }
}
