package com.maiora.foodapp.service;

import com.maiora.foodapp.entity.FoodItem;
import java.util.List;

public interface FoodService {
    List<FoodItem> getAllFoodItems();
    FoodItem getFoodItemById(Long id);
}
