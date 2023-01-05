package com.example.demo.student;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    // API endpoint, this one will return a list of students
    // To expose this as an endpoint we use below anotation
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping
    public void addStudent(@Valid @RequestBody Student student){
        studentService.addStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(
            @PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }
}
