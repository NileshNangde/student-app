package com.maiora.foodapp.controller;

import com.maiora.foodapp.dto.CartItemDto;
import com.maiora.foodapp.service.CartService;
import com.maiora.foodapp.service.FoodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FoodController {

	@Autowired
    private FoodService foodService;
	@Autowired
    private final CartService cartService;

    public FoodController(FoodService foodService, CartService cartService) {
        this.foodService = foodService;
        this.cartService = cartService;
    }

    @GetMapping("/")
    public String viewMenu(Model model) {
        model.addAttribute("foodItems", foodService.getAllFoodItems());
        return "menu";
    }

    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam Long foodId,
                            @RequestParam String foodName,
                            @RequestParam double price,
                            @RequestParam int quantity) {
        CartItemDto item = new CartItemDto(foodId, foodName, price, quantity);
        cartService.addToCart(item);
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("cart", cartService.getCart());
        return "cart";
    }

    @PostMapping("/cart/instructions")
    public String addInstructions(@RequestParam String instructions) {
        cartService.setSpecialInstructions(instructions);
        return "redirect:/cart";
    }
}
