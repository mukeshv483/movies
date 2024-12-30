package com.example.demo.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

/**
 * @author Mukesh Verma
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieBookingRequest {
    String userId;
    String email;
    Integer noOfTickets;
    SeatType seatType;
    String movieName;
    String cinemaHallName;
    String screenName;
    Address address;



}
