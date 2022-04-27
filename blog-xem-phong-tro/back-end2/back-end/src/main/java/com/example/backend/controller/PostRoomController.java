package com.example.backend.controller;

import com.example.backend.dto.PostRoomDTO;
import com.example.backend.model.Account;
import com.example.backend.model.Post;
import com.example.backend.model.Rooms;
import com.example.backend.service.AreaService;
import com.example.backend.service.PostRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PostRoomController {
    @Autowired
    private PostRoomService PostRoomService;
    @Autowired
    private AreaService AreaService;

//    @GetMapping("/addNewPost")
//    public ModelAndView UpRoom(Model model) {
//        model.addAttribute("area", AreaService.findAll());
//        return new ModelAndView("create", "PostRoomDTO", new PostRoomDTO());
//    }

    @PostMapping("/addNewPost")
    public String UpPostRoom(@ModelAttribute PostRoomDTO postRoomDTO) {
//        Post( String imgroom, String description, int quantity, double price, String datepost, Set< Rooms > rooms, Account
//        account)
        Post post = new Post(postRoomDTO.getImgroom(),postRoomDTO.getDescription(),postRoomDTO.getQuantity(),postRoomDTO.getPrice(),true);
        PostRoomService.save(post);
        return "/";
    }
}
