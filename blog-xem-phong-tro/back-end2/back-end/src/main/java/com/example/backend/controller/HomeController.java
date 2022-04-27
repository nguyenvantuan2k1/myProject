package com.example.backend.controller;

import com.example.backend.model.Account;
import com.example.backend.model.Area;
import com.example.backend.model.Rooms;
import com.example.backend.security.AccountService1Impl;
import com.example.backend.service.AreaService;
import com.example.backend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
     AreaService areaservice;
    @Autowired
    RoomService roomService;
    @RequestMapping("")
    public String homePage(Model model) {
        List<Area> area = areaservice.findAll();
        List<Rooms> rooms= roomService.findAll();
        model.addAttribute("areas", area);
        model.addAttribute("rooms", rooms);
        return "views/asset/html/Homescreens";
    }

}
