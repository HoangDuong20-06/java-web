package org.restaurant.bai5.controller;

import org.restaurant.bai5.service.OrderService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestController
@RequestMapping("/bai5/OrderB5")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/{id}")
    public String getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }
    @PostMapping
    public String createOrder() {
        return orderService.createOrder();
    }
    @DeleteMapping("/{id}")
    public String cancelOrder(@PathVariable Long id) {
        return orderService.cancelOrder(id);
    }
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handleTypeMismatch() {
        return "Lỗi: ID đơn hàng phải là một số (ví dụ: 1, 2, 3). Vui lòng kiểm tra lại!";
    }
}
