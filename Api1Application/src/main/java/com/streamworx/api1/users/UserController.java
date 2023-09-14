package com.streamworx.api1.users;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping
    private ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(userService.getCacheableUsers());
    }
}
