package com.miproyecto.inventorymanager.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class FoodProduct extends Product{
    private LocalDate expirationDate;
    private static final BigDecimal IVA_RATE = new BigDecimal("0.05");

    public FoodProduct(Long id, String name, BigDecimal price, ProductCategory productCategory, LocalDate expirationDate){
        super(id, name, price, productCategory);
        setExpirationDate(expirationDate);
    }

    public FoodProduct(String name, BigDecimal price, ProductCategory productCategory, LocalDate expirationDate){
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
    public BigDecimal  calculateTaxes() {
        BigDecimal taxAmount = getPrice().multiply(IVA_RATE);
        return taxAmount.setScale(2, RoundingMode.HALF_UP);
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
