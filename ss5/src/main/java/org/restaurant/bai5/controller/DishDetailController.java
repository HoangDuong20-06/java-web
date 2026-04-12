package org.restaurant.bai5.controller;

import org.restaurant.bai2.modal.Dish;
import org.restaurant.bai5.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bai5/dished")
public class DishDetailController {
    @Autowired
    private OrderService service;
    @GetMapping("/{id}")
    public String getDishDetail(@PathVariable("id") int id, Model model){

        Dish dish = service.getDishById(id);
        if (dish == null) {
            throw new RuntimeException("Dish not found!");
        }

        model.addAttribute("dish", dish);
        return "detail";
    }
    @ExceptionHandler(RuntimeException.class)
    public String handleError(Model model, Exception e) {
        model.addAttribute("errorMessage", e.getMessage());
        return "error";
    }
}