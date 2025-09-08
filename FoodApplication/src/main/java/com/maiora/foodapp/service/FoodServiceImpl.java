package com.maiora.foodapp.service;

import com.maiora.foodapp.entity.FoodItem;
import com.maiora.foodapp.repository.FoodItemRepository;
import com.maiora.foodapp.service.FoodService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    private final FoodItemRepository repo;

    public FoodServiceImpl(FoodItemRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<FoodItem> getAllFoodItems() {
        return repo.findAll();
    }

    @Override
    public FoodItem getFoodItemById(Long id) {
        return repo.findById(id).orElseThrow();
    }
}
