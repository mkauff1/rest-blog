package com.example.restblog.web;

import com.example.restblog.data.Post;
import com.example.restblog.service.EmailService;
import com.example.restblog.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsController {

    private final UserService userService;

    public PostsController(UserService userService){
        this.userService = userService;
    }

    private final EmailService emailService;

    public PostsController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping
    public List<Post> getAll() {
        return userService.getPostList();
    }

    @GetMapping("{id}")
    public Post getById(@PathVariable Long id) {
        for (Post post : userService.getPostList()) {
            if (Objects.equals(post.getId(), id)) {
                return post;
            }
        }
        return new Post();
    }

    @PostMapping
    public void createPost(@RequestBody Post postToAdd){
        System.out.println(postToAdd);
    }

    @PostMapping("{username}")
    public void createByUsername(@PathVariable String username, @RequestBody Post newPost){
        userService.addPost(newPost, username);
    }


    @PutMapping("{id}")
    public void updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {
        for (Post post : userService.getPostList()){
            if (post.getId().equals(id)){
                post.setContent(updatedPost.getContent());
                post.setTitle(updatedPost.getTitle());
            }
        }
    }

    @DeleteMapping("{id}")
    public void deletePost(@PathVariable Long id) {
        userService.deletePostById(id);
    }
}
