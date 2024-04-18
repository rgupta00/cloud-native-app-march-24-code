package com.empapp.service;

import com.empapp.entities.Employee;
import com.empapp.exceptions.EmployeeNotFoundException;
import com.empapp.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElseThrow(()-> new EmployeeNotFoundException("emp not found"));
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        Employee employeeToUpdate= getEmployeeById(id);
        employeeToUpdate.setSalary(employee.getSalary());
        return employeeRepository.save(employeeToUpdate);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
