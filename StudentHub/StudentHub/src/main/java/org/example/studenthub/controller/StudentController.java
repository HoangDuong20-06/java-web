package org.example.studenthub.controller;

import org.example.studenthub.model.Student;
import org.example.studenthub.service.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    // UC-01 + UC-03 (List + Sort + Search)
    @GetMapping
    public String list(
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(value = "faculty", required = false) String faculty,
            Model model) {

        List<Student> students;

        if ((search != null && !search.isEmpty()) || (faculty != null && !faculty.isEmpty())) {
            students = studentService.search(search, faculty);
            model.addAttribute("message",
                    "Tìm thấy " + students.size() + " sinh viên phù hợp");
        } else {
            students = studentService.getAllStudents(sortBy);
        }

        model.addAttribute("students", students);
        return "student-list";
    }

    // UC-02: Detail
    @GetMapping("/detail")
    public String detail(@RequestParam("id") Long id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "student-detail";
    }
}