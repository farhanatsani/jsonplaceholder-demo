package com.springworx.api2.post;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "post")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostEntity {
    @Id
    private long id;
    @Column(name = "user_id")
    private long userId;
    @Column(name = "title")
    private String title;
    @Column(name = "body")
    private String body;
}
