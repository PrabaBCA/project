package org.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }


    // =========================
    // GET ALL
    // =========================

    @GetMapping
    public List<Student> getStudents() {

        return service.getAllStudents();
    }


    // =========================
    // GET BY ID
    // =========================

    @GetMapping("/{id}")
    public Student getStudent(
            @PathVariable int id) {

        return service.getStudent(id);
    }


    // =========================
    // POST
    // =========================

    @PostMapping
    public ResponseEntity<String> addStudent(
            @RequestBody Student student) {

        service.addStudent(student);

        return ResponseEntity.ok(
                "Student added successfully"
        );
    }


    // =========================
    // PUT
    // =========================

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(
            @PathVariable int id,
            @RequestBody Student student) {

        service.updateStudent(id, student);

        return ResponseEntity.ok(
                "Student updated successfully"
        );
    }


    // =========================
    // DELETE
    // =========================

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(
            @PathVariable int id) {

        service.deleteStudent(id);

        return ResponseEntity.ok(
                "Student deleted successfully"
        );
    }
}