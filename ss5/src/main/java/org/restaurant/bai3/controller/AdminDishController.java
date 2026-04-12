package org.restaurant.bai3.controller;

import org.restaurant.bai2.modal.Dish;
import org.restaurant.bai3.service.AdminDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AdminDishController {

    @Autowired
    private AdminDishService dishService;

    @GetMapping("/bai3/edit/{id}")
    public String editDish(@PathVariable("id") int id, Model model) {

        Dish dish = dishService.findById(id);
        if (dish == null) {
            model.addAttribute("error", "Không tìm thấy món ăn yêu cầu!");
            return "redirect:/bai2/dishes";
        }

        model.addAttribute("dish", dish);

        return "edit-dish";
    }
    @PostMapping("/bai3/update")
    public String updateDish(@ModelAttribute("dish") Dish dish, RedirectAttributes redirectAttributes) {
        dishService.update(dish);
        redirectAttributes.addFlashAttribute("success", "Cập nhật thành công!");
        return "redirect:/bai2/dishes";
    }
}
