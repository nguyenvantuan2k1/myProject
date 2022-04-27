package com.example.backend.service;

import com.example.backend.model.Rooms;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface RoomService {
    List<Rooms> findAll();

    Page<Rooms> findAll(Pageable pageable);

    List<Rooms> findAll(Sort sort);

    List<Rooms> findById(int id);

    Rooms getRoomsById(int id);
}
