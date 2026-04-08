package org.example.studenthub.service;

import org.example.studenthub.model.Student;

import java.util.List;
import java.util.Map;

public interface IStudentService {
    List<Student> getAllStudents(String sortBy);
    Student findById(Long id);
    List<Student> search(String name, String faculty);
    int totalStudents();
    double avgGpa();
    Student topStudent();
    java.util.Map<String, Double> percentByStatus();
}
