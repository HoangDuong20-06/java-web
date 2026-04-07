package org.example.controller;

import org.example.modal.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {
    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String listEmployees(Model model) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1,"Nguyễn Văn A", "Hà Nội",12000));
        list.add(new Employee(2,"Trần Thị B","HCM", 8500));
        list.add(new Employee(3,"Lê Văn C","Đà Nẵng", 15000));
        model.addAttribute("employeeList", list);
        return "employee-list";
    }
}