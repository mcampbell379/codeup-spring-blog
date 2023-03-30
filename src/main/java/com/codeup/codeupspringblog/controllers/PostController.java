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
    public String createPost(@ModelAttribute Post post) {
        post.setCreator(userDao.findById(1L).get());

        postDao.save(post);

        return "redirect:/posts";
    }


    // i think this is reusing the create but not sure
    @GetMapping("/{id}/edit")
    public String getEditPostForm(@PathVariable long id, Model model){
        model.addAttribute("post", postDao.findById(id));
        return "posts/create";
    }
}
