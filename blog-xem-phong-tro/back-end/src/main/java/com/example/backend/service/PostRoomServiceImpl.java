package com.example.backend.service;

import com.example.backend.dto.PostRoomDTO;
import com.example.backend.model.Post;
import com.example.backend.reponsitory.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostRoomServiceImpl implements PostRoomService{

    @Autowired
    private PostRepository postRepository;
    @Override
    public void save(PostRoomDTO post) {
        postRepository.savePost(post.getTitle(), post.getDescription(), post.getQuantity(),
                post.getPrice(), post.getImgroom(),post.getArea(), post.getAccount(), post.getDatepost(), post.isActive());
    }
}
