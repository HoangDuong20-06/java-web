package org.restaurant.bai3.service;

import org.restaurant.bai2.modal.Dish;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminDishService {

    private static final List<Dish> dishes = new ArrayList<>();

    static {
        dishes.add(new Dish(1, "Phở bò", 50000, true));
        dishes.add(new Dish(2, "Bún chả", 40000, false));
        dishes.add(new Dish(3, "Cơm tấm", 45000, true));
    }

    public Dish findById(int id) {
        return dishes.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public void update(Dish updatedDish) {
        for (int i = 0; i < dishes.size(); i++) {
            if (dishes.get(i).getId() == updatedDish.getId()) {
                dishes.set(i, updatedDish);
                return;
            }
        }
    }
    public List<Dish> getAllDishes() {
        return dishes;
    }
}
