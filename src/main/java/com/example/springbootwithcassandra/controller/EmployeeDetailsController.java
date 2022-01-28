package com.example.springbootwithcassandra.controller;

import com.example.springbootwithcassandra.impl.EmployeeDetailsImpl;
import com.example.springbootwithcassandra.request.EmployeeRequest;
import com.example.springbootwithcassandra.response.EmployeeResponse;
import com.example.springbootwithcassandra.to.EmployeeDetailsTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class EmployeeDetailsController {

 private final static Logger logger =  LoggerFactory.getLogger(EmployeeDetailsController.class);

 private EmployeeDetailsImpl employeeService;

 @Autowired
 public EmployeeDetailsController(EmployeeDetailsImpl employeeService) {
  this.employeeService = employeeService;
 }

 @PostMapping("/employee")
    private ResponseEntity<String> createEmployee(@RequestBody EmployeeRequest request) {
    logger.info("START createEmployee() Controller"+request);
     String message="";
     EmployeeResponse employeeResponse = new EmployeeResponse();

    if(request!=null) {
        try {
            message = employeeService.createEmployee(request);
            employeeResponse.setMessage(message);
            employeeResponse.setSuccess(true);

        } catch (Exception e) {
            employeeResponse.setMessage(message);
            employeeResponse.setSuccess(false);
        }

    } else {
       logger.info("Request can not be null");

    }
    logger.info("END createEmployee() Controller "+message);
    return new ResponseEntity<>(message,HttpStatus.CREATED);

   }

   @GetMapping("/employee")
    private ResponseEntity<EmployeeResponse> getAllEmployees() {
    logger.info("Start getAllEmployees() Controller ");
    EmployeeResponse employeeResponse = new EmployeeResponse();

    try {
     List<EmployeeDetailsTo> employeeDetailsTos = employeeService.getAllEmployeesData();
     employeeResponse.setMessage("List of Employee data");
     employeeResponse.setSuccess(true);
     employeeResponse.setTotalRecords(employeeDetailsTos.size());
     employeeResponse.setEmployeeDetailsTo(employeeDetailsTos);

    } catch (Exception e) {

     employeeResponse.setMessage("Exception while getting data");
     employeeResponse.setSuccess(false);
     employeeResponse.setTotalRecords(0);

    }
    logger.info("END getAllEmployees()  control response" +employeeResponse);
    return new ResponseEntity<>(employeeResponse,HttpStatus.OK);

   }

}
