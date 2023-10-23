package kr.co.galaxy.app.pilates.application.dto;

import kr.co.galaxy.app.pilates.domain.Customer;
import lombok.Getter;

import java.util.Date;

@Getter
public class CustomerResponse {
    private int id;
    private String name;
    private String status;


    public CustomerResponse(int id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public static CustomerResponse of(Customer customer) {
        return new CustomerResponse(customer.getId(), customer.getName(), customer.getStatus());
    }


}
