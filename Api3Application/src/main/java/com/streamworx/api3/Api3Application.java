package com.streamworx.api3;

import com.streamworx.configuration.JsonPlaceholderApiConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ JsonPlaceholderApiConfiguration.class })
public class Api3Application {
    public static void main(String[] args) {
        SpringApplication.run(Api3Application.class, args);
    }
}
