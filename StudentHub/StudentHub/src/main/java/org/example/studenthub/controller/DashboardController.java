package org.example.studenthub.controller;

import org.example.studenthub.service.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final IStudentService studentService;

    public DashboardController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("total", studentService.totalStudents());
        model.addAttribute("avgGpa", String.format("%.2f", studentService.avgGpa()));
        model.addAttribute("topStudent", studentService.topStudent());
        model.addAttribute("percent", studentService.percentByStatus());
        return "dashboard";
    }
}