package com.miproyecto.inventorymanager.repository;

import java.util.List;
import java.util.Optional;

import com.miproyecto.inventorymanager.excepcion.ProductSaveException;
import com.miproyecto.inventorymanager.model.Product;

public interface ProductRepository {
    
    Product save(Product product);

    Optional<Product> findById(Long id);

    List<Product> findAll();

    Optional<Product> delete(Long id);
}
