package org.restaurant.bai4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @GetMapping("/bai4/product")
    public String getProducts(
            @RequestParam("category") String category,
            @RequestParam("limit") Integer limit,
            ModelMap model
    ) {
        model.addAttribute("cate", category)
                .addAttribute("lim", limit)
                .addAttribute("msg", "Hệ thống đã tìm thấy các món ăn phù hợp!");
        return "productList";
    }
}
