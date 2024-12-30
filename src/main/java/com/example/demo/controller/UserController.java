package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Mukesh Verma
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
     private final UserService userService;


    @GetMapping("/user/{userId}")
    public ResponseEntity<String> getUserName(@PathVariable("userId") String id){
        if(id.equals("1")){
            throw new RuntimeException("unknown user");

        }
        return ResponseEntity.ok(userService.getData(id));
    }


}
