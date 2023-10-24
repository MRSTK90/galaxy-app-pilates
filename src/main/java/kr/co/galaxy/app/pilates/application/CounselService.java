package kr.co.galaxy.app.pilates.application;

import kr.co.galaxy.app.pilates.application.dto.CounselRequest;
import kr.co.galaxy.app.pilates.application.dto.CounselResponse;
import kr.co.galaxy.app.pilates.domain.Counsel;
import kr.co.galaxy.app.pilates.domain.CounselRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CounselService {

    private final CounselRepository repository;

    public CounselResponse createCounsel(CounselRequest request){
        Counsel counsel = repository.save(request.toCounsel());
        return CounselResponse.of(counsel);
    }

}
