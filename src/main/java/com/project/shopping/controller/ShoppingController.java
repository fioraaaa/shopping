package com.project.shopping.controller;

import com.project.shopping.dto.PurchaseRequestDto;
import com.project.shopping.service.ShoppingService;
import com.project.shopping.dto.PurchaseResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {

    @Autowired
    private ShoppingService shoppingService;

    @PostMapping("/purchase")
    public PurchaseResponseDto purchase(@RequestBody PurchaseRequestDto purchaseRequestDto) {
        return shoppingService.findMaxSpend(purchaseRequestDto);
    }
}
