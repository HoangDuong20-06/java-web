package org.restaurant.bai5.repository;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    public String findOrder(Long id) {
        return "Chi tiết đơn hàng số: " + id;
    }

    public String saveOrder() {
        return "Tạo đơn hàng mới thành công!";
    }

    public String deleteOrder(Long id) {
        return "Đã xóa đơn hàng số: " + id;
    }
}
