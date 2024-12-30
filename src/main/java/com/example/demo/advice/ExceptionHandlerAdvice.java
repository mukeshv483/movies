package com.example.demo.advice;

import com.example.demo.metrices.MetricesCollector;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
   @Autowired
    private MetricesCollector metricesCollector;

//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<Object> handleException(MethodArgumentNotValidException ex,
//                                                  HttpHeaders headers,
//                                                  HttpStatus status,
//                                                  WebRequest request) {
//        ApiError apiError = ApiError.builder()
//                .error(status)
//                .message("Server Error")
//                .status(status.value())
//                .timestamp(Instant.now().toEpochMilli())
//                .build();
//        List<String> errors = new ArrayList<>();
//        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
//            errors.add(error.getField() + ": " + error.getDefaultMessage());
//        }
//        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
//            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
//        }
//        apiError.setMessage(String.join("; ", errors));
//        return handleExceptionInternal(ex, apiError,headers, status, request);
//    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Object> handleExceptionStatus(Exception ex,
//                                                  WebRequest request) {
//        ApiError apiError = ApiError.builder()
//                .error(HttpStatus.INTERNAL_SERVER_ERROR)
//                .message("Server Error")
//                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
//                .timestamp(Instant.now().toEpochMilli())
//                .build();
//        return handleExceptionInternal(ex, apiError,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
//    }
   // @ExceptionHandler(Exception.class)
    public ProblemDetail handleExceptionStatus(Exception ex,
                                               WebRequest request) {
        metricesCollector.incrementExceptionCount();
        ProblemDetail problemDetails = ProblemDetail
                .forStatusAndDetail
                        (HttpStatus.NOT_FOUND,ex.getLocalizedMessage());
        problemDetails.setType(URI.create(
                "http://localhost:8080/errors/customer-not-found"));
        problemDetails.setTitle(ex.getMessage());
        // Adding non-standard property
        problemDetails.setProperty("Exception", ex.toString());
        return problemDetails;
    }
}
