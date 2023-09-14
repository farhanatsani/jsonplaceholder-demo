package com.springworx.api2.post;

import com.streamworx.post.Post;
import com.streamworx.todo.Todo;

public class PostMapper {
    public static PostEntity toPostEntity(Post post) {
        return new PostEntity(post.getId(), post.getUserId(), post.getTitle(), post.getBody());
    }
    public static Post toPost(PostEntity postEntity) {
        return new Post(postEntity.getId(), postEntity.getUserId(), postEntity.getTitle(), postEntity.getBody());
    }
}
