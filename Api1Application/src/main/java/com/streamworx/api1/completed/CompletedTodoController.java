package com.streamworx.api1.completed;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
@AllArgsConstructor
public class CompletedTodoController {
    private final CompletedTodoService completedTodoService;
    @GetMapping
    public ResponseEntity<?> getCompletedTodos() {
        return ResponseEntity.ok(completedTodoService.getCompletedTodos());
    }
}
