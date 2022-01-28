package com.example.springbootwithcassandra.impl;


import com.example.springbootwithcassandra.dao.EmployeeDetailsDao;
import com.example.springbootwithcassandra.entity.EmployeeDetailsEntity;
import com.example.springbootwithcassandra.request.EmployeeRequest;
import com.example.springbootwithcassandra.service.EmployeeService;
import com.example.springbootwithcassandra.to.EmployeeDetailsTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeDetailsImpl implements EmployeeService {

    private final static Logger logger = LoggerFactory.getLogger(EmployeeDetailsImpl.class);

    @Autowired
    private EmployeeDetailsDao employeeDetailsDao;

    @Override
    public String createEmployee(EmployeeRequest employeeRequest) {
        logger.info(" START createEmployee() service request" + employeeRequest);

        String message = "";
        EmployeeDetailsEntity employeeDetailsEntity = new EmployeeDetailsEntity();

        try {
            employeeDetailsEntity.setEmployeeId(UUID.randomUUID().toString());
            employeeDetailsEntity.setEmployeeEmail(employeeRequest.getEmployeeEmail());
            employeeDetailsEntity.setEmployeeName(employeeRequest.getEmployeeName());
            employeeDetailsEntity.setEmployeeSalary(employeeRequest.getEmployeeSalary());
            employeeDetailsDao.save(employeeDetailsEntity);
            message = "Data is Successfully Inserted into the Database";

        } catch (Exception e) {
            message = "Exception while data update";

            logger.error("Exception occurred while updating the data" + e.getMessage());

        }
        logger.info("END createEmployee() service request " + message);

        return message;

    }

    @Override
    public List<EmployeeDetailsTo> getAllEmployeesData() {
        logger.info("START getAllEmployeesData() from DB ");

        List<EmployeeDetailsTo> listOfEmpData = new ArrayList<>();

        try {
            List<EmployeeDetailsEntity> employeeDetailsEntityList = employeeDetailsDao.findAll();

            for (EmployeeDetailsEntity employeeDetailsEntity : employeeDetailsEntityList) {
                EmployeeDetailsTo employeeDetailsTo = new EmployeeDetailsTo();

                employeeDetailsTo.setEmployeeId(UUID.fromString(employeeDetailsEntity.getEmployeeId()));
                employeeDetailsTo.setEmployeeName(employeeDetailsEntity.getEmployeeName());
                employeeDetailsTo.setEmployeeEmail(employeeDetailsEntity.getEmployeeEmail());
                employeeDetailsTo.setEmployeeSalary(employeeDetailsEntity.getEmployeeSalary());
                listOfEmpData.add(employeeDetailsTo);
            }

        } catch (Exception e) {
            logger.info("Error while getting all the employee data " + e.getMessage());

        }
        logger.info("END getAllEmployeesData() from Database " + listOfEmpData);
        return listOfEmpData;
    }
}
