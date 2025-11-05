package com.miproyecto.inventorymanager.model;

import java.time.LocalDate;

public class FoodProduct extends Product{
    private LocalDate expirationDate;
    private static final double IVA_RATE = 0.05;

    public FoodProduct(Long id, String name, double price, ProductCategory productCategory, LocalDate expirationDate){
        super(id, name, price, productCategory);
        setExpirationDate(expirationDate);
    }

    public FoodProduct(String name, double price, ProductCategory productCategory, LocalDate expirationDate){
        super(name, price, productCategory);
        setExpirationDate(expirationDate);
    }

    public FoodProduct(FoodProduct source){
        super(source);
        this.expirationDate = source.expirationDate;
    }
    private void validateExpiringDate(LocalDate localDate){
        LocalDate now = LocalDate.now();
        if (localDate.isBefore(now)) {
            throw new IllegalArgumentException("Date cannot be older than today´s date");
        }
    }
    @Override
    public double calculateTaxes() {
        return getPrice() * IVA_RATE;
    }
    @Override
    public Product clone() {
        return new FoodProduct(this);
    }

    public LocalDate getExpirationDate() {
        return this.expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        validateExpiringDate(expirationDate);
        this.expirationDate = expirationDate;
    }



}
