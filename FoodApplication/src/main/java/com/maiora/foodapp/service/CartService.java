package com.maiora.foodapp.service;

import com.maiora.foodapp.dto.CartDto;
import com.maiora.foodapp.dto.CartItemDto;

public interface CartService {
    void addToCart(CartItemDto item);
    CartDto getCart();
    void setSpecialInstructions(String instructions);
}
