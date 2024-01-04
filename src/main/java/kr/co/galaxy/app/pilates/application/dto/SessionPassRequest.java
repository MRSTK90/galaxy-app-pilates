package kr.co.galaxy.app.pilates.application.dto;

import kr.co.galaxy.app.pilates.domain.Customer;
import kr.co.galaxy.app.pilates.domain.SessionPass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SessionPassRequest {

    private Customer customer;
    private String type;
    private int count;

    public SessionPass toSessionPass() {
        return new SessionPass(type, count, customer);
    }
}
