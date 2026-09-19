package org.example;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents() {
        return repository.getAllStudents();
    }

    public Student getStudent(int id) {
        return repository.getStudent(id);
    }

    public void addStudent(Student student) {
        repository.addStudent(student);
    }

    public void updateStudent(int id, Student student) {
        repository.updateStudent(id, student);
    }

    public void deleteStudent(int id) {
        repository.deleteStudent(id);
    }
}