package com.example.backend.reponsitory;

import com.example.backend.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    @Modifying
    @Transactional
    @Query(value = "insert into Post(title, description, quantity, price, imgroom, area_id, account_id, datepost, active) values (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9 )", nativeQuery = true)
    void savePost(String title, String description, int quantity, double price, String imgroom,int area,int account, String datepost, boolean active);
}
