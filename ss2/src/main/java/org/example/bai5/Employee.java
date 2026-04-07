package org.example.bai5;

public class Employee {
    private String code;
    private String name;
    private String department;
    private Double salary;
    private String joinDate;
    private String status;

    public Employee() {
    }

    public Employee(String code, String name, String department, Double salary, String joinDate, String status) {
        this.code = code;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.joinDate = joinDate;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
