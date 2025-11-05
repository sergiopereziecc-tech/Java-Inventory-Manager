package com.miproyecto.inventorymanager.app;

import java.time.LocalDate;
import java.util.List;

import com.miproyecto.inventorymanager.model.ClothingProduct;
import com.miproyecto.inventorymanager.model.ElectronicProduct;
import com.miproyecto.inventorymanager.model.FoodProduct;
import com.miproyecto.inventorymanager.model.Product;
import com.miproyecto.inventorymanager.model.ProductCategory;
import com.miproyecto.inventorymanager.model.ClothingProduct.Material;
import com.miproyecto.inventorymanager.model.ClothingProduct.Size;
import com.miproyecto.inventorymanager.service.InMemoryProductService;

public class Main {
    public static void main(String[] args) {
        InMemoryProductService service = new InMemoryProductService();

        ClothingProduct shirt = new ClothingProduct("Shirt", 20, ProductCategory.CLOTHING, Size.L, Material.COTTON);
        ElectronicProduct computer = new ElectronicProduct(3, "Computer", 300, ProductCategory.ELECTRONICS);
        FoodProduct apple = new FoodProduct("Golden Apple", 0.2, ProductCategory.FOOD, LocalDate.of(2025, 12, 20));

        service.save(shirt);
        service.save(computer);
        service.save(apple);

        
        List<Product> allProducts = service.findAll();
        double totalTaxes = 0.0;
        for (Product product : allProducts) {
            double itemTax = product.calculateTaxes();
            totalTaxes += itemTax;
            System.out.println("Tax: " + product.calculateTaxes());
            System.out.println(product.getClass().getSimpleName());
        }
        System.out.println("Total taxes: " + totalTaxes);
    }

}
