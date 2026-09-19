package org.example;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // GET all students
    public List<Student> getAllStudents() {

        String sql = "SELECT * FROM student";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("marks")
                )
        );
    }

    // GET student by ID
    public Student getStudent(int id) {

        String sql = "SELECT * FROM student WHERE id = ?";

        return jdbcTemplate.queryForObject(
                sql,
                (rs, rowNum) ->
                        new Student(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getInt("marks")
                        ),
                id
        );
    }

    // POST
    public void addStudent(Student student) {

        String sql =
                "INSERT INTO student(name, marks) VALUES (?, ?)";

        jdbcTemplate.update(
                sql,
                student.getName(),
                student.getMarks()
        );
    }

    // PUT
    public void updateStudent(int id, Student student) {

        String sql =
                "UPDATE student SET name = ?, marks = ? WHERE id = ?";

        jdbcTemplate.update(
                sql,
                student.getName(),
                student.getMarks(),
                id
        );
    }

    // DELETE
    public void deleteStudent(int id) {

        String sql =
                "DELETE FROM student WHERE id = ?";

        jdbcTemplate.update(sql, id);
    }
}