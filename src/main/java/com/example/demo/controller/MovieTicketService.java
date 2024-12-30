package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author Mukesh Verma
 */
@Service
public class MovieTicketService {
    @Autowired  MovieTicketBookingFacade movieTicketBookingFacade;
    public Mono<MovieBookingResponse> createBooking(MovieBookingRequest movieBookingRequest) {
        movieTicketBookingFacade.getAvailibity();
        movieTicketBookingFacade.saveBooking(movieBookingRequest);
        return  Mono.empty();

    }
}
