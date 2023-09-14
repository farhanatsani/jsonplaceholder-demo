package com.springworx.api2.post;

import com.streamworx.configuration.JsonPlaceholderApiConfiguration;
import com.streamworx.post.Post;
import com.streamworx.post.PostList;
import com.streamworx.todo.TodoList;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostService {
    private final JsonPlaceholderApiConfiguration apiConfiguration;
    private final PostRepository postRepository;
    public List<Post> fetchPosts() {
        return apiConfiguration.webClient()
                .get()
                .uri(uri -> uri
                        .path(apiConfiguration.getPostUri())
                        .build()
                )
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Post>>() {})
                .block();
    }
    public PostList fetchThenSave() {
        List<PostEntity> postEntities = postRepository.findAll();
        if(postEntities.isEmpty()) {
            postEntities = fetchPosts().stream()
                    .map(PostMapper::toPostEntity).collect(Collectors.toList());

            postRepository.saveAll(postEntities);
        }

        PostList postList = new PostList();
        postList.setPosts(postEntities.stream()
                .map(PostMapper::toPost).collect(Collectors.toList()));

        return postList;
    }
}
