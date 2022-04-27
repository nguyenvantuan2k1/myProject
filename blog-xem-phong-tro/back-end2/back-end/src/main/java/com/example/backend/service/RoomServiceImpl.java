package com.example.backend.service;

import com.example.backend.model.Rooms;
import com.example.backend.reponsitory.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{

    @Autowired
    RoomRepository roomRepository;
    @Override
    public List<Rooms> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public Page<Rooms> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Rooms> findAll(Sort sort) {
        return null;
    }

    @Override
    public List<Rooms> findById(int id) {
        List<Rooms> res= roomRepository.findAllById(id);
        return res;
    }

    @Override
    public Rooms getRoomsById(int id) {
        return roomRepository.getRoomsById(id);
    }
}
