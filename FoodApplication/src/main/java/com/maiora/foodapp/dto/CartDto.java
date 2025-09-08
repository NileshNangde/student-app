package com.maiora.foodapp.dto;

import lombok.*;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDto {
    private List<CartItemDto> items = new ArrayList<>();
    private double tax;
    private double deliveryCharge;
    private double total;
    private String specialInstructions;
}
