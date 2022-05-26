package com.example.restblog.service;

import com.example.restblog.data.Post;
import com.example.restblog.data.User;
import com.example.restblog.data.UserRepository;
import com.example.restblog.web.dto.UpdateUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository usersRepository;

    private List<User> userList = setUserList();
    private List<Post> posts = setPostList();

    @Autowired
    public UserService(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<User> getUserList(){
        return userList;
    }

    public List<Post> getPostList(){
        return posts;
    }

    public void addPost(Post newPost, String username){
        User user = getUserByUsername(username);
        user.getPosts().add(newPost);
        newPost.setUser(user);
        posts.add(newPost);
    }

    public void updateUser(UpdateUserDto updateUserDto){
        User user = usersRepository.findById(updateUserDto.getId()).orElseThrow();

        if(updateUserDto.getUsername() != null && !updateUserDto.getUsername.isEmpty()){
            user.setUsername(updateUserDto.getUsername());
        }
        if(updateUserDto.getEmail() != null && !updateUserDto.getEmail.isEmpty()){
            user.setEmail(updateUserDto.getEmail());
        }
        usersRepository.save(user);
    }

//     TODO: .equals does not want to work
    public User getUserById(Long id){
        for (User user : userList) {
            if (user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }

    public User getUserByUsername(String username){
        for (User user : userList){
            if (user.getUsername().equals(username)){
                return user;
            }
        };
        return null;
    }

    public void deletePostById(long id){
        for (Post post : posts){
            if (post.getId() == id){
                posts.remove(post);
                return;
            }
        }
    }

    private List<User> setUserList(){
        List<User> userList = new ArrayList<>();
        userList.add(new User("mkauff", "mkauff@gmail.com", "password"));
        userList.add(new User("ryGuy", "ryGuy@gmail.com", "RysTheMan"));
        userList.add(new User("casey1", "casey1@gmail.com", "mrRogers"));
        return userList;
    }

    private List<Post> setPostList(){
        List<Post> postList = new ArrayList<>();
        postList.add(new Post(1L, "Cool Title", "Cool Stuff"));
        postList.add(new Post(2L, "Yes Title", "Yes stuff"));
        postList.add(new Post(3L, "No Title", "No stuff"));
        return postList;
    }
}
