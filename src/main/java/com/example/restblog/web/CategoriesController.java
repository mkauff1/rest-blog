package com.example.restblog.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class CategoriesController {

    @GetMapping
    private void getPostsByCategory(@RequestParam String categoryName){

    }
}
