package com.project.shopping.service;

import com.project.shopping.dto.PurchaseRequestDto;
import com.project.shopping.dto.PurchaseResponseDto;
import com.project.shopping.model.Product;
import com.project.shopping.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingService {

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public void initData() {
        if (productRepository.count() == 0) {
            productRepository.save(new Product("MouseA", 12000));
            productRepository.save(new Product("MouseB", 20000));
            productRepository.save(new Product("MouseC", 35000));
            productRepository.save(new Product("KeyboardA", 12000));
            productRepository.save(new Product("KeyboardB", 20000));
            productRepository.save(new Product("KeyboardC", 35000));
        }
    }

    public PurchaseResponseDto findMaxSpend(PurchaseRequestDto purchaseRequestDto) {
        int budget = purchaseRequestDto.getBudget();

        // Mendapatkan semua variasi harga untuk Keyboard dan Mouse
        List<Product> keyboards = productRepository.findByName("Keyboard");
        List<Product> mice = productRepository.findByName("Mouse");

        int maxSpend = 0;
        String selectedKeyboardName = "";
        int selectedKeyboardPrice = 0;
        String selectedMouseName = "";
        int selectedMousePrice = 0;

        // Menggabungkan setiap variasi harga Keyboard dan Mouse untuk memaksimalkan pengeluaran
        for (Product keyboard : keyboards) {
            for (Product mouse : mice) {
                int totalSpend = keyboard.getPrice() + mouse.getPrice();
                if (totalSpend <= budget && totalSpend > maxSpend) {
                    maxSpend = totalSpend;
                    selectedKeyboardName = keyboard.getName();
                    selectedKeyboardPrice = keyboard.getPrice();
                    selectedMouseName = mouse.getName();
                    selectedMousePrice = mouse.getPrice();
                }
            }
        }

        return new PurchaseResponseDto(maxSpend, selectedKeyboardName, selectedKeyboardPrice, selectedMouseName, selectedMousePrice);
    }
}

