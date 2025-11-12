package com.miproyecto.inventorymanager.service;


import java.util.List;

import java.util.Optional;


import com.miproyecto.inventorymanager.model.Product;
import com.miproyecto.inventorymanager.repository.InMemoryProductRepositoryImpl;
import com.miproyecto.inventorymanager.repository.ProductRepository;

public class ProductServiceImplement implements ProductService{

    ProductRepository repository = new InMemoryProductRepositoryImpl();

    public Product save(Product product) {
        return repository.save(product);
    }
    
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }
    
    public List<Product> findAll() {
        return repository.findAll();
    }
    public Optional<Product> delete(Long id){
        return repository.delete(id);
            
    }
}
