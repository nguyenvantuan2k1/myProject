package com.example.backend.controller;

import com.example.backend.model.Rooms;
import com.example.backend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class AreadistinctController {

    @Autowired
    RoomService roomService;

    @RequestMapping("/getAreaRoom/{id}")
    public String getArea(@PathVariable int id, Model model){
        List<Rooms> rooms = roomService.findById(id);
        model.addAttribute("rooms",rooms);
        String areaname =rooms.get(0).getPost().getArea().getName();
        model.addAttribute("areaname",areaname);
        return "views/asset/html/areaDistinct";
    }
}
