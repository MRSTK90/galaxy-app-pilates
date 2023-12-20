package kr.co.galaxy.app.pilates.ui;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import kr.co.galaxy.app.pilates.application.AcceptanceTest;
import kr.co.galaxy.app.pilates.application.dto.CustomerRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Class Description
 *
 * @author SungTae Kim
 * @version 1.0
 * @class CustomerControllerTest
 * @modification
 */
class CustomerControllerTest extends AcceptanceTest {

    @Test
    @DisplayName("회원 생성 테스트")
    void createCustomer() {
        //given
        CustomerRequest request = CustomerRequest.builder()
                .name("홍길동")
                .sex("m")
                .dateOfBirth(LocalDate.parse("1990-01-01"))
                .build();

        //when
        ExtractableResponse<Response> response = given().log().all()
                .body(request)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().post("customer/create")
                .then().log().all().extract();

        //then
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());


    }

    @Test
    @DisplayName("회원 조회 테스트")
    void getCustomer() {
    }
}