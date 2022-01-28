package com.example.springbootwithcassandra.request;

public class EmployeeRequest {

    private String employeeName;
    private int employeeSalary;
    private String employeeEmail;

    public EmployeeRequest() {
    }

    public EmployeeRequest(String employeeName, int employeeSalary, String employeeEmail) {
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    @Override
    public String toString() {
        return "EmployeeRequest{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeSalary=" + employeeSalary +
                ", employeeEmail='" + employeeEmail + '\'' +
                '}';
    }
}
