package kr.co.galaxy.app.pilates.application.dto;

import kr.co.galaxy.app.pilates.domain.SessionPass;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class SessionPassResponse {

    private UUID customerId;
    private String type;
    private int count;

    public static SessionPassResponse of(SessionPass response) {
        return new SessionPassResponse(response.getCustomer().getId(), response.getType(), response.getCount());
    }
}
