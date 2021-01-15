package com.socialfeedapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {

    @Id
    @Column(name = "post_id")
    @GeneratedValue
    private int id;
    private String text;
    @Column(name = "createdAt")
    private Date createdAt;
    @Column(name = "usernameAuthor")
    private String usernameAuthor;
}
