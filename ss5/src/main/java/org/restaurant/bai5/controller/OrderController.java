package org.restaurant.bai5.controller;

import jakarta.servlet.http.HttpSession;
import org.restaurant.bai2.modal.Dish;
import org.restaurant.bai5.modal.OrderItem;
import org.restaurant.bai5.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/bai5/order")
public class OrderController {
    @Autowired
    private OrderService service;
    @PostMapping("/add")
    public String addToCart(@RequestParam("id") int id, @RequestParam("redirectUrl") String redirectUrl, HttpSession session, RedirectAttributes redirectAttributes) {
        List<OrderItem> cart = (List<OrderItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        Dish dish = service.getDishById(id);
        boolean found = false;
        for (OrderItem item : cart) {
            if (item.getDish().getId() == id) {
                item.setQuantity(item.getQuantity() + 1);
                found = true;
                break;
            }
        }
        if (!found && dish != null) {
            cart.add(new OrderItem(dish, 1));
        }
        session.setAttribute("cart", cart);
        redirectAttributes.addFlashAttribute("msg", "Đã thêm vào giỏ!");
        return "redirect:" + redirectUrl;
    }
    @GetMapping
    public String viewCart(Model model, HttpSession session) {
        List<OrderItem> cart = (List<OrderItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        double total = service.calculateTotal(cart);

        model.addAttribute("cart", cart);
        model.addAttribute("total", total);
        return "order";
    }
    @PostMapping("/clear")
    public String clearCart(HttpSession session) {
        session.removeAttribute("cart");
        return "redirect:/bai5/order";
    }
    @PostMapping("/checkout")
    public String checkout(HttpSession session, Model model) {
        List<OrderItem> cart = (List<OrderItem>) session.getAttribute("cart");
        if (cart == null || cart.isEmpty()) {
            model.addAttribute("message", "Giỏ hàng trống!");
            return "order";
        }
        double total = service.calculateTotal(cart);
        session.removeAttribute("cart");
        model.addAttribute("message", "Đặt món thành công!");
        model.addAttribute("total", total);
        return "result";
    }
}
