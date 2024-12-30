package com.example.demo.controller;

import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * @author Mukesh Verma
 */
@Service
@Data
public class UserService {

    String name;
    String id;
    String details;

     public String getFullName(){
         return String.join("--",this.name,this.id);
     }
    public String getData(String id){
        return id;
    }
}
