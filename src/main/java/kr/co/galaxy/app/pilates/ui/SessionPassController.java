package kr.co.galaxy.app.pilates.ui;

import kr.co.galaxy.app.pilates.application.SessionPassService;
import kr.co.galaxy.app.pilates.application.dto.SessionPassRequest;
import kr.co.galaxy.app.pilates.application.dto.SessionPassResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class Description
 *
 * @author SungTae Kim
 * @version 1.0
 * @class SessionPassController
 * @modification <pre>
 * since	    author	        description
 * ---------	------------	---------------------
 * 2024-01-04      SungTae Kim	    최초 작성
 * </pre>
 */

@RestController
@RequestMapping("session-pass")
@RequiredArgsConstructor
public class SessionPassController {

    private final SessionPassService sessionPassService;

    @PostMapping("create")
    public ResponseEntity<SessionPassResponse> create(@RequestBody SessionPassRequest request){
        SessionPassResponse sessionPass = sessionPassService.register(request);
        return ResponseEntity.ok(sessionPass);
    }
}
