package com.example.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ModController {
    @RequestMapping("/mod")
    public String HomeMod(){
        return "views/asset/html/admin/index";
    }
    @RequestMapping("/mod/charts")
    public String Chart(){
        return "views/asset/html/admin/layout/charts";
    }
    @GetMapping("/mod/danhSachPhong")
    public String danhSachPhong(){
        return "views/asset/html/admin/layout/tables";
    }
}
