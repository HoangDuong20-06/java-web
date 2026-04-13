package org.example.controller;

import org.example.modal.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping
public class ParkController {
    List<Person> personList = new ArrayList<>(Arrays.asList(
            new Person("1", "nva", 20, false),
            new Person("2", "nvb", 20, false),
            new Person("3", "nvc", 20, true),
            new Person("4", "nvd", 20, false)
    ));

    @GetMapping
    public String home(Model model) {
        model.addAttribute("persons", personList);
        return "park";
    }

}
