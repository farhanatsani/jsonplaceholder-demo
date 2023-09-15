package com.streamworx.api1.completed;

import com.streamworx.api1.users.UserService;
import com.streamworx.completedtodos.CompletedTodo;
import com.streamworx.post.Api2Client;
import com.streamworx.post.Post;
import com.streamworx.todo.Api3Client;
import com.streamworx.todo.Todo;
import com.streamworx.user.Address;
import com.streamworx.user.Company;
import com.streamworx.user.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class CompletedTodoService {
    private final UserService userService;
    private final Api2Client api2Client;
    private final Api3Client api3Client;
    public List<CompletedTodo> getCompletedTodos() {
        List<User> users = userService.getCacheableUsers();
        List<Post> posts = api2Client.getPosts();
        List<Todo> todos = api3Client.getTodos();

        return users.stream()
                .map(user -> new CompletedTodo(
                        user.getId(), user.getUsername(), user.getName(), user.getEmail(), user.getAddress(),
                        user.getPhone(), user.getWebsite(), user.getCompany(), filterTodoByUser(todos, user.getId()),
                        filterPostByUser(posts, user.getId())))
                .collect(Collectors.toList());
    }
    private List<Todo> filterTodoByUser(List<Todo> todos, long userId) {
        return todos.stream()
                .filter(todo -> todo.getUserId() == userId)
                .collect(Collectors.toList());
    }
    private List<Post> filterPostByUser(List<Post> posts, long userId) {
        return posts.stream()
                .filter(post -> post.getUserId() == userId)
                .collect(Collectors.toList());
    }
}
