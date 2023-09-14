package com.streamworx.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Configuration
public class JsonPlaceholderApiConfiguration {
    @Value("${json-placeholder-api.base-url}")
    private String baseUrl;
    @Value("${json-placeholder-api.todos-uri}")
    private String todoUri;
    @Value("${json-placeholder-api.users-uri}")
    private String userUri;
    @Value("${json-placeholder-api.posts-uri}")
    private String postUri;
    @Bean
    public WebClient webClient() {
        HttpClient client = HttpClient.create()
                .responseTimeout(Duration.ofSeconds(3));

        return WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .clientConnector(new ReactorClientHttpConnector(client))
                .build();
    }
    public String getBaseUrl() {
        return baseUrl;
    }
    public String getTodoUri() {
        return todoUri;
    }
    public String getUserUri() {
        return userUri;
    }
    public String getPostUri() {
        return postUri;
    }
}
