package com.streamworx.completedtodos;

import com.streamworx.post.Post;
import com.streamworx.todo.Todo;
import com.streamworx.user.Address;
import com.streamworx.user.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class CompletedTodo {
    private long id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;
    private List<Todo> todos;
    private List<Post> posts;
}
