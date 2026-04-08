package org.example.studenthub.service.impl;

import org.example.studenthub.model.Student;
import org.example.studenthub.repository.impl.StudentRepository;
import org.example.studenthub.service.IStudentService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service //
public class StudentService implements IStudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents(String sortBy) {
        List<Student> students = studentRepository.findAll();

        if (sortBy == null || sortBy.isEmpty()) {
            return students;
        }
        return switch (sortBy.toLowerCase()) {
            case "name" -> students.stream()
                    .sorted(Comparator.comparing(s -> s.getFullName().toLowerCase()))
                    .toList();
            case "gpa" -> students.stream()
                    .sorted(Comparator.comparingDouble(Student::getGpa).reversed())
                    .toList();
            default -> students;
        };
    }

    @Override
    public int totalStudents() {
        return studentRepository.findAll().size();
    }

    @Override
    public double avgGpa() {
        return studentRepository.findAll().stream()
                .mapToDouble(Student::getGpa)
                .average()
                .orElse(0.0);
    }

    @Override
    public Student topStudent() {
        return studentRepository.findAll().stream()
                .max(Comparator.comparingDouble(Student::getGpa))
                .orElse(null);
    }

    @Override
    public Map<String, Double> percentByStatus() {
        List<Student> students = studentRepository.findAll();
        int total = students.size();

        if (total == 0) return Map.of();

        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::getStatus,
                        Collectors.collectingAndThen(
                                Collectors.counting(),
                                count -> (count * 100.0) / total
                        )
                ));
    }
    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> search(String name, String faculty) {
        return studentRepository.findAll().stream()
                .filter(s -> (name == null || name.isEmpty() || s.getFullName().toLowerCase().contains(name.toLowerCase())) &&
                        (faculty == null || faculty.isEmpty() || s.getFaculty().equalsIgnoreCase(faculty)))
                .collect(Collectors.toList());
    }

    
}