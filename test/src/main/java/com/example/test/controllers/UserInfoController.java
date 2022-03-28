package com.example.test.controllers;


import com.example.test.models.AppUser;
import com.example.test.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    @RequestMapping("/api/user")
    public class UserInfoController {

@Autowired
        private UserRepository userRepo;

        @GetMapping("/info")
        public AppUser getUserDetails(){
            String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return userRepo.findAppUserByEmail(email).get();
        }



    }
