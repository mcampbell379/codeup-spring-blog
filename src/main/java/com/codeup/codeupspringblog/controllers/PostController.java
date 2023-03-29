package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
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
    private final UserRepository userDao;

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

        model.addAttribute("post", post);
        return "showPost";
    }

    @GetMapping("/create")
    public String getCreatePostForm(Model model) {
        model.addAttribute("post", new Post());
        return "create";
    }
    @PostMapping("/create")
    public String createPost(
//            @RequestParam User user,  ****** going to be used when adding the ability to log in
            @RequestParam String title,
            @RequestParam String body)
    {
        Post post = new Post();
        post.setUser(userDao.findById(1L).get());
        post.setTitle(title);
        post.setBody(body);
        postDao.save(post);

        return "redirect:/posts";
    }
}
