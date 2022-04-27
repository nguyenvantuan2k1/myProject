package com.example.backend.controller;

import com.example.backend.dto.PostRoomDTO;
import com.example.backend.reponsitory.AccountRepository;
import com.example.backend.service.AreaService;
import com.example.backend.service.PostRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;


@Controller
public class PostRoomController {
    @Autowired
    private PostRoomService postRoomService;

    @Autowired
    private AreaService AreaService;

    @Autowired
    private AccountRepository accountRepository;

//    @GetMapping("/addNewPost")
//    public ModelAndView UpRoom(Model model) {
//        model.addAttribute("area", AreaService.findAll());
//        return new ModelAndView("create", "PostRoomDTO", new PostRoomDTO());
//    }

    @PostMapping("/addNewPost")
    public String UpPostRoom(Model model,@ModelAttribute PostRoomDTO postRoomDTO, BindingResult bindingResult) {

        System.out.println(java.time.LocalDate.now());
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute(postRoomDTO);
            return "views/asset/html/postRoom";
        }
        postRoomDTO.setActive(true);
        postRoomDTO.setDatepost(String.valueOf(java.time.LocalDate.now()));
        postRoomService.save(postRoomDTO);
        System.out.println("thanh cong");
        return "redirect:/";
    }
}
