package com.streamworx.post;

import lombok.*;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class Post {
    private long id;
    private long userId;
    private String title;
    private String body;
}
