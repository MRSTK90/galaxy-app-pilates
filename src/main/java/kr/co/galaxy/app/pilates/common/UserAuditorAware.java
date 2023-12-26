package kr.co.galaxy.app.pilates.common;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Class Description
 *
 * @author kst
 * @version 1.0
 * @class UserAuditorAware
 * @modification
 **/

@Component
public class UserAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        //return Optional.empty();
        return Optional.ofNullable("kst");
    }
}
