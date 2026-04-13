package org.restaurant.bai2.controller;

import org.restaurant.bai2.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MenuController {
    private final OrderService orderService;
    public MenuController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/bai2/menu")
    @ResponseBody
    public String getMenu(@RequestParam(name = "category", required = false, defaultValue = "chay") String category
    ) {
        return "Thực đơn phân loại theo: " + category;
    }
    @GetMapping("/bai2/order")
    @ResponseBody
    public String getAllOrders() {
        return orderService.getAllOrders();
    }
}
