package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author Mukesh Verma
 */
@Service
public class UserReactiveService {

   @Autowired
   private UserReactiveRepository userReactiveRepository;

    public Mono<User> getUser(Long id){
        return  userReactiveRepository.findById(id);
    }


}
