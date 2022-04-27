package com.example.backend.controller;


import com.example.backend.model.Rooms;
import com.example.backend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class AllRoomController {

    @Autowired
    RoomService roomService;
    @RequestMapping("/allrooms")
    public String getAllRooms(Model model) {
        List<Rooms> rooms = roomService.findAll();
        model.addAttribute("rooms", rooms);
        return "views/asset/html/allRooms";
    }
}
