package com.example.restblog.web;

import com.example.restblog.data.Post;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsController {

//    private final UserService userService;
//
//    public PostsController(UserService userService){
//        this.userService = userService
//    }

    List<Post> posts = new ArrayList<>();

    @GetMapping
    public List<Post> getAll() {
        posts.add(new Post(1L, "Cool Title", "Cool Stuff"));
        posts.add(new Post(2L, "Yes Title", "Yes stuff"));
        posts.add(new Post(3L, "No Title", "No stuff"));

        return posts;
    }

    @GetMapping("{id}")
    public Post getById(@PathVariable Long id) {
        for (Post post : getAll()) {
            if (Objects.equals(post.getId(), id)) {
                return post;
            }
        }
        return new Post();
    }

    @GetMapping("{username}")
    public Collection<Post> getByUser(@PathVariable String username){

    }
    @PostMapping
    public void createPost(@RequestBody Post postToAdd){
        System.out.println(postToAdd);
    }

    @PutMapping("{id}")
    public void updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {
        for (Post post : posts){
            if (post.getId().equals(id)){
                post.setContent(updatedPost.getContent());
                post.setTitle(updatedPost.getTitle());
            }
        }
    }

    @DeleteMapping("{id}")
    public void deletePost(@PathVariable Long id) {
        System.out.println("Deleting post with id: " + id);
    }
}
