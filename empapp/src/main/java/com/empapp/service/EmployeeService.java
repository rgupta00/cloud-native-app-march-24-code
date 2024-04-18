package com.empapp.service;

import com.empapp.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    Employee updateEmployee(int id , Employee employee);
    void deleteEmployee(int id);
}
