package kr.co.galaxy.app.pilates.application;

import kr.co.galaxy.app.pilates.application.dto.CustomerRequest;
import kr.co.galaxy.app.pilates.application.dto.CustomerResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Class Description
 *
 * @author osstem
 * @version 1.0
 * @class CustomerServiceTest
 * @modification
 *
 */

class CustomerServiceTest extends AcceptanceTest{

    @Autowired
    CustomerService customerService;

    @Test
    @DisplayName("회원이 생성된다.")
    void createCustomer() {
        CustomerRequest request = CustomerRequest.builder()
                .name("홍길동")
                .sex("m")
                .dateOfBirth(LocalDate.parse("1990-01-01"))
                .build();

        CustomerResponse response = customerService.createCustomer(request);
        assertThat(response.getId().toString().length()).isEqualTo(36);

    }

    @Test
    @DisplayName("ID로 회원을 조회한다.")
    void findCustomerById() {
        CustomerRequest request = CustomerRequest.builder()
                .name("홍길동")
                .sex("m")
                .dateOfBirth(LocalDate.parse("1990-01-01"))
                .build();

        CustomerResponse createdCustomer = customerService.createCustomer(request);
        CustomerResponse response = customerService.findCustomerById(createdCustomer.getId());
        assertThat(response).isNotNull();
    }

}