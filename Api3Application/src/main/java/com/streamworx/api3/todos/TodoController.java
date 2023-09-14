package com.streamworx.api3.todos;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/todos")
public class TodoController {
    private final TodoService todoService;
    @GetMapping
    private ResponseEntity<?> getTodos() {
        return ResponseEntity.ok(todoService.getTodos());
    }
}
