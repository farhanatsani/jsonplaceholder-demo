package com.streamworx.post;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("api2")
public interface Api2Client {
    @GetMapping("/api/posts")
    List<Post> getPosts();
}
