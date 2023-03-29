package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
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

        return "posts/index";
    }

    @GetMapping("/{postId}")
    public String getIndividualPost(@PathVariable long postId, Model model) {
        Post post = postDao.findById(postId).get();
        System.out.println(post);

        model.addAttribute("post", post);
        return "posts/showPost";
    }

    @GetMapping("/create")
    public String getCreatePostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }
    @PostMapping("/create")
    public String createPost(
//            @RequestParam User user,  ****** going to be used when adding the ability to log in
            @ModelAttribute Post post)
    {
        post.setUser(userDao.findById(1L).get());

        postDao.save(post);

        return "redirect:/posts";
    }
}
