package org.restaurant.bai5.service;

import org.restaurant.bai5.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String getOrder(Long id) { return orderRepository.findOrder(id); }
    public String createOrder() { return orderRepository.saveOrder(); }
    public String cancelOrder(Long id) { return orderRepository.deleteOrder(id); }
}