package com.dev.springboot.lesson.repository;

import com.dev.springboot.lesson.IntegrationTestBase;
import com.dev.springboot.lesson.entity.CompanyEntity;
import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JdbcTemplateTest extends IntegrationTestBase {

    private static final String INSERT_SQL = "insert into company(name) values (?);";
    private static final String DELETE_RETURNING_SQL = "DELETE from company WHERE name = ? RETURNING *";

    @Autowired
    private JdbcOperations jdbcOperations;

    @Test
    void testInsert() {
        var result = jdbcOperations.update(INSERT_SQL, "Microsoft");
        assertEquals(1, result);
    }

    @Test
    void testReturning() {
        var companyName = "Microsoft";
        jdbcOperations.update(INSERT_SQL, companyName);

        var result = jdbcOperations.query(DELETE_RETURNING_SQL,
                (rs, rowNum) -> CompanyEntity.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build(), companyName);
        assertThat(result, hasSize(1));
    }
}
