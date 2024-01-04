package kr.co.galaxy.app.pilates.application;

import kr.co.galaxy.app.pilates.application.dto.SessionPassRequest;
import kr.co.galaxy.app.pilates.application.dto.SessionPassResponse;
import kr.co.galaxy.app.pilates.domain.SessionPass;
import kr.co.galaxy.app.pilates.domain.SessionPassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SessionPassService {

    private final SessionPassRepository sessionPassRepository;

    @Transactional(readOnly = false)
    public SessionPassResponse register(SessionPassRequest request){
        SessionPass sessionPass = request.toSessionPass();
        SessionPass response = sessionPassRepository.save(sessionPass);
        return SessionPassResponse.of(response);
    }

}
