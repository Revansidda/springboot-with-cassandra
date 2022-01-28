package com.example.springbootwithcassandra.service;

import com.example.springbootwithcassandra.request.EmployeeRequest;
import com.example.springbootwithcassandra.to.EmployeeDetailsTo;

import java.util.List;


public interface EmployeeService {

     String createEmployee(EmployeeRequest employeeRequest);

     List<EmployeeDetailsTo> getAllEmployeesData();
}
