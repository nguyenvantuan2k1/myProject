package com.example.backend.controller;

import com.example.backend.dto.PostRoomDTO;
import com.example.backend.model.Account;
import com.example.backend.model.Area;
import com.example.backend.model.Rooms;
import com.example.backend.reponsitory.AccountRepository;
import com.example.backend.service.AreaService;
import com.example.backend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    AreaService areaservice;

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/postRoom/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String postRooms(Model model){
        List<Area> area = areaservice.findAll();
        List<Account> account = accountRepository.findByAccountRoleAdmin();
        boolean check = false;
        model.addAttribute("check",check);
        model.addAttribute("area",area);
        model.addAttribute("account",account);
        model.addAttribute("postRoomDTO",new PostRoomDTO());
        return "views/asset/html/postRoom";
    }

    @GetMapping("403")
    public String error(){
        return "views/asset/html/403";
    }
}
