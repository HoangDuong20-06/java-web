package org.example.studenthub.repository.impl;

import org.example.studenthub.repository.IStudentRepository;
import org.example.studenthub.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository implements IStudentRepository {
    private final List<Student> students;

    public StudentRepository() {
        students = new ArrayList<>();

        students.add(new Student(1L, "Phạm Thành An", "SV001", "CNTT", 2022, 3.65, "Đang học"));
        students.add(new Student(2L, "Trần Minh Quân", "SV002", "CNTT", 2021, 3.91, "Đang học"));
        students.add(new Student(3L, "Lê Thu Hà", "SV003", "KTPM", 2022, 3.45, "Bảo lưu"));
        students.add(new Student(4L, "Phạm Gia Bảo", "SV004", "HTTT", 2020, 3.91, "Tốt nghiệp"));
        students.add(new Student(5L, "Đoàn Ngọc Anh", "SV005", "CNTT", 2023, 3.28, "Đang học"));
        students.add(new Student(6L, "Bài Tuấn Kiệt", "SV006", "KTPM", 2021, 3.74, "Đang học"));
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    @Override
    public Student findById(Long id) {
        Optional<Student> optionalStudent = students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();

        return optionalStudent.orElse(null);
    }
}
