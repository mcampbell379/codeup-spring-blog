package com.codeup.codeupspringblog.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post {
    private long id;
    private String title;
    private String body;
}
