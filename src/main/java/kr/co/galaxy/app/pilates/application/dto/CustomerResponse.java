package kr.co.galaxy.app.pilates.application.dto;

import kr.co.galaxy.app.pilates.domain.Customer;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
public class CustomerResponse {
    private UUID id;
    private String name;
    private String status;


    public CustomerResponse(UUID id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public static CustomerResponse of(Customer customer) {
        return new CustomerResponse(customer.getId(), customer.getName(), customer.getStatus());
    }


}
