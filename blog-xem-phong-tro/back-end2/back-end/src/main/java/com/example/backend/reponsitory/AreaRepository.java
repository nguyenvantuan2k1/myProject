package com.example.backend.reponsitory;

import com.example.backend.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {

//    void delete(int id);
//    Optional<Area> findById(int id);

}
