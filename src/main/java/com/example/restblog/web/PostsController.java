package com.example.restblog.web;

import com.example.restblog.data.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsController {

    List<Post> posts = new ArrayList<>();

    @GetMapping
    private List<Post> getAll() {
        posts.add(new Post(1L, "Cool Title", "Cool Stuff"));
        posts.add(new Post(2L, "Yes Title", "Yes stuff"));
        posts.add(new Post(3L, "No Title", "No stuff"));

        return posts;
    }

}
