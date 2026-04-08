package org.restaurant.bai1.repository;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepo {
    public String getAllOrders() {
        return "Danh sách toàn bộ đơn hàng (Clean Code)";
    }

    public String getOrderById(Long id) {
        return "Thông tin đơn hàng với ID: " + id;
    }
}
