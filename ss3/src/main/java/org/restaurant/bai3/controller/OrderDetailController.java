package org.restaurant.bai3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderDetailController {
    @GetMapping("/bai3/order/{id}")
    public String getOrder(@PathVariable("id") Long id) {
        return "Chi tiết đơn hàng số " + id;
    }
}
