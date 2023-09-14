package com.streamworx.api1;

import com.streamworx.configuration.JsonPlaceholderApiConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ JsonPlaceholderApiConfiguration.class })
@EnableFeignClients(
        basePackages = { "com.streamworx.todo", "com.streamworx.post" }
)
public class Api1Application {
    public static void main(String[] args) {
        SpringApplication.run(Api1Application.class, args);
    }
}
