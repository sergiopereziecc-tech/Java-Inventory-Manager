package com.miproyecto.inventorymanager.model;

public class ElectronicProduct extends Product{
    private int warrantyMonths;
    private static final int MIN_WARRANTY = 0;
    private static final double IVA_RATE = 0.18;

    public ElectronicProduct(int warrantyMonths, Long id, String name, double price, ProductCategory productCategory){
        super(id, name, price, productCategory);
        setWarrantyMonths(warrantyMonths);
    }
    public ElectronicProduct(int warrantyMonths, String name, double price, ProductCategory productCategory){
        super(name, price, productCategory);
        setWarrantyMonths(warrantyMonths);
    }

    public ElectronicProduct(ElectronicProduct source){
        super(source);
        setWarrantyMonths(source.warrantyMonths);
    }
    @Override
    public Product clone() {
        return new ElectronicProduct(this);
    }
    @Override
    public double calculateTaxes() {
        return getPrice() * IVA_RATE;
    }

    public int getWarrantyMonths() {
        return this.warrantyMonths;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        if (warrantyMonths < MIN_WARRANTY) {
            throw new IllegalArgumentException("Warranty has to be greater than " + MIN_WARRANTY);
        }
        this.warrantyMonths = warrantyMonths;
    }

}
