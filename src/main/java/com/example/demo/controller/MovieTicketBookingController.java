package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Mukesh Verma
 */
@RestController
@RequestMapping("/api/v1")
public class MovieTicketBookingController {
    @Autowired
    MovieTicketService movieTicketService;

    @GetMapping
    public Mono<MovieBookingResponse> createBooking( @RequestParam MovieBookingRequest movieBookingRequest) {
        return movieTicketService.createBooking(movieBookingRequest);

    }
}
