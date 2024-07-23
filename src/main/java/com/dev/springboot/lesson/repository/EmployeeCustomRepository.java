package com.dev.springboot.lesson.repository;

import com.dev.springboot.lesson.dto.EmployeeFilter;
import com.dev.springboot.lesson.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeCustomRepository {

    List<EmployeeEntity> findByFilter(EmployeeFilter filter);
}
