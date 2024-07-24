package com.dev.springboot.lesson.repository;

import com.dev.springboot.lesson.dto.EmployeeFilter;
import com.dev.springboot.lesson.entity.EmployeeEntity;
import com.dev.springboot.lesson.entity.QEmployeeEntity;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeCustomRepository {

    private final EntityManager entityManager;

    @Override
    public List<EmployeeEntity> findByFilter(EmployeeFilter filter) {
        return new JPAQuery<EmployeeEntity>(entityManager)
                .select(QEmployeeEntity.employeeEntity)
                .from(QEmployeeEntity.employeeEntity)
                .where(QEmployeeEntity.employeeEntity.firstName.containsIgnoreCase(filter.getFirstName()))
                .fetch();
    }
}
