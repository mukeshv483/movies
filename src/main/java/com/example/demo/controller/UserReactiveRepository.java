package com.example.demo.controller;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Mukesh Verma
 */
@Repository
public interface UserReactiveRepository extends ReactiveCrudRepository<User, Long> {

}
