package com.example.StudentApp.controller;


import com.example.StudentApp.entity.Student;
import com.example.StudentApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public Student create(@RequestBody Student student) {
        return service.createStudent(student);
    }

    @GetMapping
    public List<Student> getAll() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteStudent(id);
        return "Student deleted successfully";
    }
    @GetMapping("/search/name")
    public List<Student> searchByName(@RequestParam String name) {
        return service.searchByName(name);
    }
    @GetMapping("/search/department")
    public List<Student> searchByDepartment(@RequestParam String department) {
        return service.searchByDepartment(department);
    }
}
