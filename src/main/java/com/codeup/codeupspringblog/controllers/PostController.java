package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String getPostIndex() {
        return "gets posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String getIndividualPost(@PathVariable int id) {
        return "views an individual post with an id of: " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String getCreatePostForm() {
        return "gets the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "physically creates a new post via post request";
    }
}
