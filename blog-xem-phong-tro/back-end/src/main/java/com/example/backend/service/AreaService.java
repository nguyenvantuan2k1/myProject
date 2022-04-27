package com.example.backend.service;

import com.example.backend.model.Area;

import java.util.List;
import java.util.Optional;

public interface AreaService {
    List<Area> findAll();

    void save(Area category);

    void delete(int id);

    Optional<Area> findById(int id);
}
