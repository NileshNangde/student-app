package com.maiora.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.maiora.foodapp.entity.FoodItem;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
}
