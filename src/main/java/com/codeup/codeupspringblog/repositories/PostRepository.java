package com.codeup.codeupspringblog.repositories;

import com.codeup.codeupspringblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository <Post, Long>{

    // for searching a post by title later
    // List<Post> findByTitle(String title);
}
