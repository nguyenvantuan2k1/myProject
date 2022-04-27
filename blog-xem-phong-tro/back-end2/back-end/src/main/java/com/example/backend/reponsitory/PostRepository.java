package com.example.backend.reponsitory;

import com.example.backend.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Modifying
    @Transactional
    @Query(value = "insert into Post values (?1, ?2, ?3, ?4, ?5, ?6, ?7)", nativeQuery = true)
    void savePost(Post post);
}
