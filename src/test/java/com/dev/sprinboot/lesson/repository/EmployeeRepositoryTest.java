package com.dev.sprinboot.lesson.repository;

import com.dev.sprinboot.lesson.IntegrationTestBase;
import com.dev.sprinboot.lesson.entity.EmployeeEntity;
import com.dev.sprinboot.lesson.projection.EmployeeNameView;
import com.dev.sprinboot.lesson.projection.EmployeeNativeView;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryTest extends IntegrationTestBase {

    private static final Integer IVAN_ID = 1;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void testFindById() {
        var employee = employeeRepository.findById(IVAN_ID);
        assertTrue(employee.isPresent());
    }

    @Test
    void testFindByFirstName() {
        var employee = employeeRepository.findByFirstNameContaining("va");
        assertTrue(employee.isPresent());
    }

    @Test
    void testFindByFirstNameAndSalary() {
        var employees = employeeRepository.findAllByFirstNameAndSalary("Ivan", 1000);
        assertThat(employees, hasSize(1));
    }

    @Test
    void testFindBySalary() {
        List<EmployeeNameView> employees = employeeRepository.findAllBySalaryGreaterThan(500);
        assertThat(employees, hasSize(2));
    }


    @Test
    void testFindBySalaryNative() {
        List<EmployeeNativeView> employees = employeeRepository.findAllBySalaryGreaterThanNative(500);
        assertThat(employees, hasSize(2));
    }

    @Test
    void testFindCustomQuery() {
        List<EmployeeEntity> customQuery = employeeRepository.findCustomQuery();
        assertThat(customQuery, hasSize(0));
    }

}