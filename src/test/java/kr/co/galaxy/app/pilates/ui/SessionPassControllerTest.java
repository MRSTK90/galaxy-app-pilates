package kr.co.galaxy.app.pilates.ui;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import kr.co.galaxy.app.pilates.application.AcceptanceTest;
import kr.co.galaxy.app.pilates.application.CustomerService;
import kr.co.galaxy.app.pilates.application.dto.CustomerRequest;
import kr.co.galaxy.app.pilates.application.dto.CustomerResponse;
import kr.co.galaxy.app.pilates.application.dto.SessionPassRequest;
import kr.co.galaxy.app.pilates.domain.Customer;
import kr.co.galaxy.app.pilates.domain.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.awt.*;
import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Class Description
 *
 * @author SungTae Kim
 * @version 1.0
 * @class SessionPassControllerTest
 * @modification <pre>
 * since	    author	        description
 * ---------	------------	---------------------
 * 2024-01-04      SungTae Kim	    최초 작성
 * </pre>
 */
class SessionPassControllerTest extends AcceptanceTest {

   @Autowired
   CustomerRepository customerRepository;


    @Test
    @DisplayName("회원 수강권 등록 테스트")
    void createSessionPass(){

        //given
        CustomerRequest requestCustomer = CustomerRequest.builder()
                .name("홍길동")
                .sex("m")
                .dateOfBirth(LocalDate.parse("1990-01-01"))
                .build();
        Customer customer = customerRepository.save(requestCustomer.toCustomer());


        SessionPassRequest request = SessionPassRequest.builder()
                .customer(customer)
                .type("S")
                .count(10)
                .build();

        //when
        ExtractableResponse<Response> response = given().log().all()
                .body(request)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().post("session-pass/create")
                .then().log().all().extract();

        //then
        assertThat(response.jsonPath().get("customerId").toString()).isEqualTo(customer.getId().toString());


    }

}