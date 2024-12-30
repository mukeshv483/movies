//package com.example.demo.controller;
//
//
//import com.example.demo.model.TestTbl;
//import com.example.demo.service.EmployeeService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
//
//@RestController
//@RequestMapping("/api/v1")
//@Slf4j
//@RequiredArgsConstructor
//public class DemoController {
//    private final TblRepository tblRepository;
//    private final EmployeeService employeeService;
//
//    @GetMapping("/employee/{id}")
//    public ResponseEntity<TestTbl> fetch(@PathVariable("id") Integer id) {
//        log.info("request received for id: {}",id);
//       Optional<TestTbl> tbl= tblRepository.findById(id);
////        if(tbl.isPresent()){
////            return ResponseEntity.ok().body(tbl.get());
////        }
//      //  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//
//        return ResponseEntity.ok().body(tbl.get());
//    }
//    @GetMapping("/employee")
//    public ResponseEntity<List<TestTbl>> fetchAll() {
//        log.info("request received for");
//        return ResponseEntity.ok().body(tblRepository.findAll());
//    }
//
//    @PostMapping(path = "/employee",
//            consumes = APPLICATION_JSON_VALUE,
//            produces = APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.CREATED)
//    public TestTbl createEmployee(@RequestBody TestTbl employee) {
//        log.info("request received for");
//        return employeeService.createEmployee(employee);
//    }
//}
