package com.empapp.service;

import com.empapp.entities.Employee;
import com.empapp.repo.EmployeeRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepo employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private Employee employee;
    @BeforeEach
    void setUp() {
         employee = Employee.builder()
                .id(1)
                .name("raj")
                .salary(7000)
                .build();
    }

    @DisplayName("JUnit test for saveEmployee method")
    @Test
    public void givenEmployeeObject_whenSaveEmployee_thenReturnEmployeeObject(){
        // given - precondition or setup
        given(employeeRepository.save(employee)).willReturn(employee);
        Employee savedEmployee = employeeService.saveEmployee(employee);
        assertThat(savedEmployee).isNotNull();
    }


    @DisplayName("JUnit test for getAllEmployees method")
    @Test
    public void givenEmployeesList_whenGetAllEmployees_thenReturnEmployeesList(){
        // given - precondition or setup

        Employee employee2 = Employee.builder()
                .id(1)
                .name("ekta")
                .salary(7000)
                .build();

        given(employeeRepository.findAll()).willReturn(List.of(employee,employee2));

        // when -  action or the behaviour that we are going test
        List<Employee> employeeList = employeeService.getAllEmployees();

        // then - verify the output
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(2);
    }


    @DisplayName("JUnit test for getAllEmployees method (negative scenario)")
    @Test
    public void givenEmptyEmployeesList_whenGetAllEmployees_thenReturnEmptyEmployeesList(){
        // given - precondition or setup

        given(employeeRepository.findAll()).willReturn(Collections.emptyList());

        // when -  action or the behaviour that we are going test
        List<Employee> employeeList = employeeService.getAllEmployees();

        // then - verify the output
        assertThat(employeeList).isEmpty();
        assertThat(employeeList.size()).isEqualTo(0);
    }

    // JUnit test for getEmployeeById method
    @DisplayName("JUnit test for getEmployeeById method")
    @Test
    public void givenEmployeeId_whenGetEmployeeById_thenReturnEmployeeObject(){
        // given
        given(employeeRepository.findById(1)).willReturn(Optional.of(employee));

        // when
        Employee savedEmployee = employeeService.getEmployeeById(employee.getId());

        // then
        assertThat(savedEmployee).isNotNull();

    }

    @AfterEach
    void tearDown() {
    }
}