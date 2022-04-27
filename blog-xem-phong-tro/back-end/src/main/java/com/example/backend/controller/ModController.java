package com.example.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/mod")
public class ModController {
    @RequestMapping("/adminPage")
    public String HomeMod(){
        return "views/asset/html/admin/index";
    }
    @RequestMapping("/mod/danhsachphong")
    public String danhSach(){
        return "views/asset/html/admin/layout/danhSachPhong";
    }
}

