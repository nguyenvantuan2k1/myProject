package com.example.backend.controller;

import com.example.backend.dto.AccountDTO;
import com.example.backend.model.Account;
import com.example.backend.model.Role;
import com.example.backend.reponsitory.AccountRepository;
import com.example.backend.reponsitory.RoleRepository;
import com.example.backend.security.AccountService1Impl;
import com.example.backend.security.JwtUtils;
import com.example.backend.security.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Set;


@Controller
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    AccountRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
//
//        @Autowired
//        SendMail sendMail;

    @Autowired
    JwtUtils jwtUtils;


    @GetMapping("user")
    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN') or hasRole('MODERATOR')")
    public String userAccess() {
        return "views/asset/html/allRooms";
    }

    @GetMapping("mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public String moderatorAccess() {
        return "views/asset/html/admin/index";
    }

    @GetMapping("admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        System.out.println("login page admin");
        return "admin";
    }

    @GetMapping("/login")
//    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String getLogin(){
        return "views/asset/html/login";
    }

    @GetMapping("/register")
    public ModelAndView getRegisterPage(){
        return new ModelAndView("views/asset/html/register","registerUser",new AccountDTO());
    }

    @PostMapping("/register")
    public String registerUser(@Validated @ModelAttribute("registerUser") AccountDTO registerUser, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "views/asset/html/login";
        }else {
            Account user = new Account();
            user.setUsername(registerUser.getUsername());
            user.setPassword(passwordEncoder.encode(registerUser.getPassword()));
            Role roleEntity = roleRepository.findByName("ROLE_USER");
            Set<Role> listRoles = new HashSet<>();
            listRoles.add(roleEntity);
            user.setRoles(listRoles);
            userRepository.save(user);
            return "redirect:/login";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
            Cookie cookie = new Cookie("remember-me", "");
            cookie.setMaxAge(24*60*60*1);
            response.addCookie(cookie);
        }
        return "redirect:/login";
    }

}