package com.springboot.mongodb.springboot_mongodb.student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "index";
    }
    @PostMapping("/submit")
    public String studentForm(@ModelAttribute("student") Student student, Model model) {
        studentService.createStudent(student);
        return "redirect:/api/students/success";
    }

    @GetMapping("/success")
    public String successPage(Model model) {
        return "success";
    }

}
