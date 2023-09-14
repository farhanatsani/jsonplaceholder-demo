package com.streamworx.todo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("api3")
public interface Api3Client {
    @GetMapping("/api/todos")
    List<Todo> getTodos();
}
