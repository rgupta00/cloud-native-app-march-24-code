package com.empapp.repo;

import com.empapp.entities.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class EmployeeRepoTest {

    @Autowired
    private EmployeeRepo employeeRepo;
    private Employee employee;

    @BeforeEach
    void setUp() {
        employee=new Employee("raj",5000);
    }
    @Test
    @Rollback(value = false)
    public void givenEmployeeObjectWhenSaveReturnEmployeeObject(){
        Employee savedEmployee= employeeRepo.save(employee);
        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getId()).isGreaterThan(0);
    }

    @DisplayName("JUnit test for get all employees operation")
    @Test
    public void givenEmployeesList_whenFindAll_thenEmployeesList(){
        // given - precondition or setup
        Employee employee = Employee.builder()
                .name("raj")
                .salary(7000)
                .build();

        Employee employee2 = Employee.builder()
                .name("ekta")
                .salary(7000)
                .build();

        employeeRepo.save(employee);
        employeeRepo.save(employee2);

        // when -  action or the behaviour that we are going test
        List<Employee> employeeList = employeeRepo.findAll();

        // then - verify the output
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(2);

    }

    @DisplayName("JUnit test for get employee by id operation")
    @Test
    public void givenEmployeeObject_whenFindById_thenReturnEmployeeObject(){
        // given - precondition or setup
        Employee employee = Employee.builder()
                .name("raj")
                .salary(7000)
                .build();
        employeeRepo.save(employee);

        // when -  action or the behaviour that we are going test
        Employee employeeDB = employeeRepo.findById(employee.getId()).get();

        // then - verify the output
        assertThat(employeeDB).isNotNull();
    }

    @DisplayName("JUnit test for update employee operation")
    @Test
    public void givenEmployeeObject_whenUpdateEmployee_thenReturnUpdatedEmployee(){
        // given - precondition or setup
        Employee employee = Employee.builder()
                .name("raj")
                .salary(7000)
                .build();
        employeeRepo.save(employee);

        // when -  action or the behaviour that we are going test
        Employee savedEmployee = employeeRepo.findById(employee.getId()).get();
        savedEmployee.setSalary(9000);
        Employee updatedEmployee =  employeeRepo.save(savedEmployee);

        assertThat(updatedEmployee.getSalary()).isEqualTo(9000);
    }

    // JUnit test for delete employee operation
    @DisplayName("JUnit test for delete employee operation")
    @Test
    public void givenEmployeeObject_whenDelete_thenRemoveEmployee(){
        // given - precondition or setup
        Employee employee = Employee.builder()
                .name("raj")
                .salary(7000)
                .build();
        employeeRepo.save(employee);

        // when -  action or the behaviour that we are going test
        employeeRepo.deleteById(employee.getId());
        Optional<Employee> employeeOptional = employeeRepo.findById(employee.getId());

        // then - verify the output
        assertThat(employeeOptional).isEmpty();
    }

    @AfterEach
    void tearDown() {
    }
}