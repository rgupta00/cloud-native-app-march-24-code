package com.empapp.controller;

import com.empapp.entities.Employee;
import com.empapp.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int employeeId){
        Employee employee= employeeService.getEmployeeById(employeeId);
        return ResponseEntity.status(HttpStatus.OK).body(employee);

    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int employeeId,
                                                   @RequestBody Employee employee){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.updateEmployee(employeeId, employee));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int employeeId){

        employeeService.deleteEmployee(employeeId);

        return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);

    }

}
