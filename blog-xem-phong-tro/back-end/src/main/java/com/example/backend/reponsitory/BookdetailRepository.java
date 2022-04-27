package com.example.backend.reponsitory;

import com.example.backend.model.Bookdetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookdetailRepository extends JpaRepository<Bookdetail, Integer> {
}
