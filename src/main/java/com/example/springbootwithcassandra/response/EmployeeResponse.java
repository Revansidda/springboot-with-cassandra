package com.example.springbootwithcassandra.response;

import com.example.springbootwithcassandra.to.EmployeeDetailsTo;

import java.util.List;

public class EmployeeResponse {

    private String message;
    private boolean isSuccess;
    private List<EmployeeDetailsTo> employeeDetailsTo;
    private int totalRecords;

    public EmployeeResponse() {
    }

    public EmployeeResponse(String message, boolean isSuccess, List<EmployeeDetailsTo> employeeDetailsTo,int totalRecords) {
        this.message = message;
        this.isSuccess = isSuccess;
        this.employeeDetailsTo = employeeDetailsTo;
        this.totalRecords=totalRecords;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public List<EmployeeDetailsTo> getEmployeeDetailsTo() {
        return employeeDetailsTo;
    }

    public void setEmployeeDetailsTo(List<EmployeeDetailsTo> employeeDetailsTo) {
        this.employeeDetailsTo = employeeDetailsTo;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    @Override
    public String toString() {
        return "EmployeeResponse{" +
                "message='" + message + '\'' +
                ", isSuccess=" + isSuccess +
                ", employeeDetailsTo=" + employeeDetailsTo +
                ", totalRecords=" + totalRecords +
                '}';
    }
}
