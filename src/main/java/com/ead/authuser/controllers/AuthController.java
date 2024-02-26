package com.ead.authuser.controllers;

import com.ead.authuser.dtos.UserCreateDTO;
import com.ead.authuser.models.UserModel;
import com.ead.authuser.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody UserCreateDTO userCreateDTO){
        var userResponse  = userService.save(userCreateDTO);
        return ResponseEntity.ok(userResponse);
    }
}
