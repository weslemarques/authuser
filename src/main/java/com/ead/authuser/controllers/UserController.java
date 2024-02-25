package com.ead.authuser.controllers;

import com.ead.authuser.models.UserModel;
import com.ead.authuser.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers(){

        return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getOneUser(@PathVariable(value = "userId") UUID userId){
        var userModelOptional = userService.findById(userId);
        return userModelOptional.<ResponseEntity<Object>>map(
                userModel -> ResponseEntity.status(HttpStatus.OK)
                        .body(userModel))
                        .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not Found"));
    }


    @DeleteMapping("/{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "userId") UUID userId){
        Optional<UserModel> userOptional = userService.findById(userId);
        if(userOptional.isEmpty()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not Found");
        }
        userService.delete(userOptional.get());
        return ResponseEntity.noContent().build();
    }


}
