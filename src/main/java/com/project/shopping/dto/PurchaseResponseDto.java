package com.project.shopping.dto;

import lombok.Data;

@Data
public class PurchaseResponseDto {
    private int maxSpend;
    private String keyboardName;
    private int keyboardPrice;
    private String mouseName;
    private int mousePrice;

    public PurchaseResponseDto(int maxSpend, String keyboardName, int keyboardPrice, String mouseName, int mousePrice) {
        this.maxSpend = maxSpend;
        this.keyboardName = keyboardName;
        this.keyboardPrice = keyboardPrice;
        this.mouseName = mouseName;
        this.mousePrice =mousePrice;
    }
}
