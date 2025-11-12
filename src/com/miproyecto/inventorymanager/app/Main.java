package com.miproyecto.inventorymanager.app;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import com.miproyecto.inventorymanager.model.ClothingProduct;
import com.miproyecto.inventorymanager.model.ElectronicProduct;
import com.miproyecto.inventorymanager.model.FoodProduct;
import com.miproyecto.inventorymanager.model.Product;
import com.miproyecto.inventorymanager.model.ProductCategory;
import com.miproyecto.inventorymanager.model.ClothingProduct.Material;
import com.miproyecto.inventorymanager.model.ClothingProduct.Size;
import com.miproyecto.inventorymanager.service.ProductServiceImplement;

public class Main {
    private static final ProductServiceImplement inventoryService = new ProductServiceImplement();

    public static void main(String[] args) {

        
        Product mouse = new ElectronicProduct(2, "LOGI", new BigDecimal("10.12"), ProductCategory.ELECTRONICS);
        Product tv = new ElectronicProduct(1, "SAMSUNG", new BigDecimal("35.50"), ProductCategory.ELECTRONICS);
        Product watermelon = new FoodProduct("Watermelon Sangre", new BigDecimal("5.12"), ProductCategory.FOOD, LocalDate.of(2025, 12, 15));


        
        Product savedWatermelon = inventoryService.save(watermelon); // ID 1
        Product savedMouse = inventoryService.save(mouse);           // ID 2
        Product savedTV = inventoryService.save(tv);
        handleDeletion(savedMouse.getId());
    }

    public static void handleDeletion(Long idAttemptToDelete) {
        System.out.println("Borrado de ID: " + idAttemptToDelete);

        try {
            Product deleteProduct = inventoryService.delete(idAttemptToDelete)
                    .orElseThrow(() -> new NoSuchElementException(
                            "Fallo: Producto con ID " + idAttemptToDelete + " no encontrado para borrar"));
            System.out.println("Exito: " + deleteProduct.getName() + "(ID: " + idAttemptToDelete + ")");
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
        }
    }
}
