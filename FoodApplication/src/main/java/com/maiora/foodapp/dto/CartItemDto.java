package com.maiora.foodapp.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItemDto {
    private Long foodId;
    private String foodName;
    private double price;
    private int quantity;
}
