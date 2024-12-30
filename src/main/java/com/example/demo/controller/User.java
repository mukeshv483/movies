package com.example.demo.controller;



import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @author Mukesh Verma
 */

public class User implements Serializable {
    String name;
   @Id
    Long id;
    String address;
}
