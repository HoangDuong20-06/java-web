package org.example.bai3;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {

    @GetMapping("/order")
    public String listOrders(HttpSession session, HttpServletRequest request) {
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }
        List<Order> list = Arrays.asList(
                new Order("HD01", "Bàn phím Aula F75", 1200000.0, new Date()),
                new Order("HD02", "Chuột Logitech G Pro", 2500000.0, new Date())
        );
        request.setAttribute("order", list);
        ServletContext application = request.getServletContext();
        synchronized (application) {
            Integer count = (Integer) application.getAttribute("totalViewCount");
            if (count == null) count = 0;
            application.setAttribute("totalViewCount", count + 1);
        }
        return "order";
    }
}
