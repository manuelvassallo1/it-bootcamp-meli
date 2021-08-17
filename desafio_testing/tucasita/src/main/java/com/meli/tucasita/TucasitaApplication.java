package com.meli.tucasita;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "TuCasita Tasaciones API",
                version = "1.0.0"))
public class TucasitaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TucasitaApplication.class, args);
    }

}
