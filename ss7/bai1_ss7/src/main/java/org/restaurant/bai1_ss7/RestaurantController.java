package org.restaurant.bai1_ss7;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RestaurantController {
    @GetMapping("/merchant/form")
    public String showForm(Model model) {
        model.addAttribute("profile", new RestaurantProfile());
        return "profile";
    }
    @PostMapping("/merchant/update-profile")
    public String updateProfile(RestaurantProfile profile) {
        System.out.println("Tên quán: " + profile.getName());
        System.out.println("SĐT: " + profile.getPhone());
        System.out.println("Active: " + profile.isActive());
        return "success";
    }
}
