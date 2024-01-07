package com.springboot.mongodb.springboot_mongodb.student;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentControllerREST {
    private final StudentService studentService;

    public StudentControllerREST(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public Student addStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/list")
    public List<Student> fetchAllStudents() {
        return studentService.getAllStudents();
    }
}

