package com.dev.sprinboot.lesson.repository;

import com.dev.sprinboot.lesson.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeCustomRepository {

    List<EmployeeEntity> findCustomQuery();
}
