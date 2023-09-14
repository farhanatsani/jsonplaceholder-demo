package com.streamworx.api3.todos;

import com.streamworx.configuration.JsonPlaceholderApiConfiguration;
import com.streamworx.todo.Todo;
import com.streamworx.todo.TodoList;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class TodoService {
    private final JsonPlaceholderApiConfiguration apiConfiguration;
    public List<Todo> getTodos() {
        return apiConfiguration.webClient()
                .get()
                .uri(uri -> uri
                        .path(apiConfiguration.getTodoUri())
                        .build()
                )
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Todo>>() {})
                .block();
    }
}
