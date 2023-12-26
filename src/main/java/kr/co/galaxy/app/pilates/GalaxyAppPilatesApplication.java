package kr.co.galaxy.app.pilates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GalaxyAppPilatesApplication {

    public static void main(String[] args) {
        SpringApplication.run(GalaxyAppPilatesApplication.class, args);
    }

}
