package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static String INSERT_QUERY =
            """
                        INSERT INTO course (ID, NAME, AUTHOR)
                        VALUES (?, ?, ?)
                    """;

    private static String SELECT_QUERY =
            """
                        SELECT id, name, author FROM COURSE WHERE ID = ?     
                    """;

    private static String UPDATE_QUERY =
            """
                        UPDATE COURSE SET NAME = ?, AUTHOR = ? WHERE ID = ?     
                    """;

    private static String DELETE_QUERY =
            """
                        DELETE FROM COURSE WHERE ID = ?     
                    """;

    public void insert(Course course) {
        jdbcTemplate.update(INSERT_QUERY,
                course.getId(), course.getName(), course.getAuthor());
    }

    public Course findById(long id) {
        return jdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }

    public void update(Course course) {
        jdbcTemplate.update(UPDATE_QUERY, course.getName(), course.getAuthor(), course.getId());
    }

    public void deleteById(long id) {
        jdbcTemplate.update(DELETE_QUERY, id);
    }

}
