package com.example.backend.service;

import com.example.backend.model.Post;
import com.example.backend.reponsitory.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostRoomServiceImpl implements PostRoomService{

    @Autowired
    private PostRepository postRepository;
    @Override
    public void save(Post post) {
        postRepository.savePost(post);
    }
}
