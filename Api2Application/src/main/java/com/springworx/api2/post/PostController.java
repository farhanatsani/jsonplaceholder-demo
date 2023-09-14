package com.springworx.api2.post;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
@AllArgsConstructor
public class PostController {
    private final PostService postService;
    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<?> getPosts() {
        return ResponseEntity.ok(postService.fetchThenSave());
    }
}
