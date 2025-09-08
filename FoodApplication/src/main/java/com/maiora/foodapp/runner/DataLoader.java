package com.maiora.foodapp.runner;

import com.maiora.foodapp.entity.FoodItem;
import com.maiora.foodapp.repository.FoodItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final FoodItemRepository repo;

    public DataLoader(FoodItemRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        repo.save(new FoodItem(null, "Pizza", 250, "https://cdn-icons-png.flaticon.com/512/3595/3595455.png"));
        repo.save(new FoodItem(null, "Burger", 150, "https://cdn-icons-png.flaticon.com/512/3075/3075977.png"));
        repo.save(new FoodItem(null, "Pasta", 200, "https://cdn-icons-png.flaticon.com/512/1046/1046784.png"));
        repo.save(new FoodItem(null, "Fries", 100, "https://cdn-icons-png.flaticon.com/512/1699/1699343.png"));
    }
}
