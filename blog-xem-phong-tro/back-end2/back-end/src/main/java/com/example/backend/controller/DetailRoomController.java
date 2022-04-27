package com.example.backend.controller;

import com.example.backend.model.Rooms;
import com.example.backend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DetailRoomController {
    @Autowired
    RoomService roomService;
    @RequestMapping("/getDetailRoom/{id}")
    public String getDetailRoom(@PathVariable int id, Model model){
        Rooms rooms = roomService.getRoomsById(id);
        model.addAttribute("rooms",rooms);
        return "views/asset/html/bookRoom";
    }
}
