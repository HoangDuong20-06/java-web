package org.restaurant.bai5.service;


import org.restaurant.bai2.modal.Dish;
import org.restaurant.bai5.modal.OrderItem;
import org.restaurant.bai5.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Dish> getMenu() {
        return repository.findAll();
    }

    public Dish getDishById(int id) {
        return repository.findById(id);
    }
    public double calculateTotal(List<OrderItem> cart) {
        return cart.stream()
                .mapToDouble(item -> item.getDish().getPrice() * item.getQuantity())
                .sum();
    }
}
