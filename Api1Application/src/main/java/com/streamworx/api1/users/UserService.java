package com.streamworx.api1.users;

import com.streamworx.configuration.JsonPlaceholderApiConfiguration;
import com.streamworx.user.User;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final JsonPlaceholderApiConfiguration apiConfiguration;
    private RedisTemplate<String, List<User>> redisTemplate;
    public List<User> getUsers() {
        return apiConfiguration.webClient()
                .get()
                .uri(uri -> uri
                        .path(apiConfiguration.getUserUri())
                        .build()
                )
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<User>>() {})
                .block();
    }
    public List<User> getCacheableUsers() {
        List<User> users = getUsers();

        redisTemplate.opsForValue().set("todo.users", users);
        redisTemplate.expire("todo.users", Duration.ofHours(1L));

        return getUsers();
    }
}
