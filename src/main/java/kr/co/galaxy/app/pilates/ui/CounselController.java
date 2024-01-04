package kr.co.galaxy.app.pilates.ui;

import kr.co.galaxy.app.pilates.application.CounselService;
import kr.co.galaxy.app.pilates.application.dto.CounselRequest;
import kr.co.galaxy.app.pilates.application.dto.CounselResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

/**
 * Class Description
 *
 * @author osstem
 * @version 1.0
 * @class CounselController
 * @modification <pre>
 * since	    author	        description
 * ---------	------------	---------------------
 * 2024-01-04      SungTae Kim	    최초 작성
 * </pre>
 */

@RestController
@RequestMapping("counsel")
@RequiredArgsConstructor
public class CounselController {

    private final CounselService counselService;

    @PostMapping("create")
    public ResponseEntity<Void> create(@RequestBody CounselRequest request){
        CounselResponse counsel = counselService.createCounsel(request);
        return ResponseEntity.created(URI.create("/counsel"+counsel.getId())).build();
    }
}
