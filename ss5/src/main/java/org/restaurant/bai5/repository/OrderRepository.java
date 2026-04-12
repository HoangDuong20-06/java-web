package org.restaurant.bai5.repository;

import org.restaurant.bai2.modal.Dish;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {

    private static final List<Dish> dishes = new ArrayList<>();

    static {
        dishes.add(new Dish(1, "Phở bò", 50000, true));
        dishes.add(new Dish(2, "Bún chả", 40000, true));
        dishes.add(new Dish(3, "Cơm tấm", 45000, true));
    }
    public List<Dish> findAll() {
        return dishes;
    }
    public Dish findById(int id) {
        return dishes.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
