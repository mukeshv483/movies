package com.example.demo.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Mukesh Verma
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieBookingResponse {

    String userName;
    UUID bookingId;
    Integer noOfTickets;
    BigDecimal bookingAmount;
    BigDecimal paidAmount;
    BigDecimal pendingAmount;
    BookingStatus  bookingStatus;
    PaymentStatus paymentStatus;
    LocalDateTime  bookingDate;

}
