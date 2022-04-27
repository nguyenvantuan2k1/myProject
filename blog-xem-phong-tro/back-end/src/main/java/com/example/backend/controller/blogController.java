package com.example.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class blogController {
    @GetMapping("/blog")
    public String GetBlog(){
        return "views/asset/html/blog";
    }
}
