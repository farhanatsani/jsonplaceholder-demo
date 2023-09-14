package com.streamworx.todo;

import lombok.*;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Todo {
    private long id;
    private long userId;
    private String title;
    private boolean completed;
}
