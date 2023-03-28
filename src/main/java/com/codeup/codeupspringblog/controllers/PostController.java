package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostRepository postDao;

    @GetMapping
    public String allPosts(Model model){
        List<Post> posts = postDao.findAll();
        model.addAttribute("posts", posts);

        return "posts";
    }

    @GetMapping("/{postId}")
    public String getIndividualPost(@PathVariable long postId, Model model) {
        Post post = postDao.findById(postId).get();
        System.out.println(post);

        model.addAttribute("title", post.getTitle());
        model.addAttribute("body", post.getBody());
        return "showPost";
    }

    @GetMapping("/create")
    public String getCreatePostForm() {
        return "create";
    }
    @PostMapping("/create")
    public String createPost(@RequestParam String title, @RequestParam String body) {
        Post post = new Post();

        post.setTitle(title);
        post.setBody(body);

        postDao.save(post);
        return "posts";
    }
}
