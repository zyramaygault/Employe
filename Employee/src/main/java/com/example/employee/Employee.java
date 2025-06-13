package com.example.employee;

public class Employee {
    private int eid;
    private String name;
    private String department;
    private String mobile;
    private double salary;

    public Employee(int eid, String name, String department, String mobile, double salary) {
        this.eid = eid;
        this.name = name;
        this.department = department;
        this.mobile = mobile;
        this.salary = salary;
    }

    public int getEid() { return eid; }
    public void setEid(int eid) { this.eid = eid; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}