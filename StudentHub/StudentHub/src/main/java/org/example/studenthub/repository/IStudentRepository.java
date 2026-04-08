package org.example.studenthub.repository;

import org.example.studenthub.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    Student findById(Long id);
}