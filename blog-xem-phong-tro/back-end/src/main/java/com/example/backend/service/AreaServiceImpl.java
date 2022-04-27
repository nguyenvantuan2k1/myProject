package com.example.backend.service;

import com.example.backend.model.Area;
import com.example.backend.reponsitory.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AreaServiceImpl implements AreaService{
    @Autowired
    AreaRepository areaRepository;


    @Override
    public List<Area> findAll() {
        return areaRepository.findAll();
    }

    @Override
    public void save(Area category) {
        areaRepository.save(category);
    }

    @Override
    public void delete(int id) {
//        areaRepository.delete(id);
    }

    @Override
    public Optional<Area> findById(int id) {
        return null;
    }
}
