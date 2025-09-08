package com.maiora.foodapp.service;

import com.maiora.foodapp.dto.CartDto;
import com.maiora.foodapp.dto.CartItemDto;
import com.maiora.foodapp.service.CartService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private final List<CartItemDto> cartItems = new ArrayList<>();
    private String specialInstructions;

    private final double TAX_RATE = 0.1; // 10%
    private final double DELIVERY_CHARGE = 50;

    @Override
    public void addToCart(CartItemDto item) {
        cartItems.add(item);
    }

    @Override
    public CartDto getCart() {
        double subtotal = cartItems.stream()
                .mapToDouble(i -> i.getPrice() * i.getQuantity())
                .sum();
        double tax = subtotal * TAX_RATE;
        double total = subtotal + tax + DELIVERY_CHARGE;

        return CartDto.builder()
                .items(new ArrayList<>(cartItems))
                .tax(tax)
                .deliveryCharge(DELIVERY_CHARGE)
                .total(total)
                .specialInstructions(specialInstructions)
                .build();
    }

    @Override
    public void setSpecialInstructions(String instructions) {
        this.specialInstructions = instructions;
    }
}
