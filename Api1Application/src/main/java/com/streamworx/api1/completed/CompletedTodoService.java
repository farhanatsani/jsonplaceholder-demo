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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CompletedTodoService {
    private final UserService userService;
    private final Api2Client api2Client;
    private final Api3Client api3Client;
    public List<CompletedTodo> getCompletedTodos() {
        List<User> users = userService.getCacheableUsers();
        List<CompletedTodo> completedTodos = new ArrayList<>();
        int pUser = 0;
        while(pUser < users.size()) {
            User user = users.get(pUser);
            CompletedTodo completedTodo = new CompletedTodo();
            completedTodo.setId(user.getId());
            completedTodo.setUsername(user.getUsername());
            completedTodo.setEmail(user.getEmail());
            completedTodo.setAddress(user.getAddress());
            completedTodo.setPhone(user.getPhone());
            completedTodo.setWebsite(user.getWebsite());
            completedTodo.setCompany(user.getCompany());
            completedTodo.setTodos(getTodoByUser(user.getId()));
            completedTodo.setPosts(getPostByUser(user.getId()));
            completedTodos.add(completedTodo);
            pUser++;
        }
        return completedTodos;
    }
    private List<Todo> getTodoByUser(long userId) {
        List<Todo> todos = api3Client.getTodos();
        int pTodo = 0;
        List<Todo> todosFilterUserId = new ArrayList<>();
        while(pTodo < todos.size()) {
            Todo todo = todos.get(pTodo);
            if(todo.getUserId() == userId) {
                todosFilterUserId.add(todo);
            }
            pTodo++;
        }
        return todosFilterUserId;
    }
    private List<Post> getPostByUser(long userId) {
        List<Post> posts = api2Client.getPosts();
        int pPost = 0;
        List<Post> postFilterUserId = new ArrayList<>();
        while(pPost < posts.size()) {
            Post post = posts.get(pPost);
            if(post.getUserId() == userId) {
                postFilterUserId.add(post);
            }
            pPost++;
        }
        return postFilterUserId;
    }
}
