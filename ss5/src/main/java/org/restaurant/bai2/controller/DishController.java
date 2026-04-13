package org.restaurant.bai2.controller;

import org.restaurant.bai2.modal.Dish;
import org.restaurant.bai3.service.AdminDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DishController {

    @Autowired
    private AdminDishService dishService;
    @GetMapping("/bai2/dished")
    public String getDishes(Model model) {
        List<Dish> dished = dishService.getAllDishes();
        model.addAttribute("dished", dished);
        return "dish-list";
    }
}
