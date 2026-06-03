package com.example.StudentApp.repository;

import com.example.StudentApp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByNameContainingIgnoreCase(String name);

    List<Student> findByDepartmentIgnoreCase(String department);
}
