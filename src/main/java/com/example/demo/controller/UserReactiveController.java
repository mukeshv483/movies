package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Mukesh Verma
 */
@RestController
@RequestMapping("/api/v2")
@RequiredArgsConstructor
public class UserReactiveController {
    private final UserReactiveService userReactiveService;
    @GetMapping("/user/{userId}")
    public Mono<ResponseEntity<User>> getUserDetails(@PathVariable("userId")Long userId){
        return userReactiveService.getUser(userId).map(ResponseEntity::ok)
                .switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).build()));

    }
}
