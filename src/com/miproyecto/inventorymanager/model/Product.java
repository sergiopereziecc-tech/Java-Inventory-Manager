package com.miproyecto.inventorymanager.model;

public abstract class Product {
    private Long id;
    private String name;
    private double price;
    private ProductCategory productCategory;


    public Product(Long id, String name, double price, ProductCategory productCategory) {
        setId(id);
        setName(name);
        setPrice(price);
        setProductCategory(productCategory);
    }
    public Product(String name, double price, ProductCategory productCategory){
        this(null, name, price, productCategory);
    }

    public Product(Product source){
        this.id = source.id;
        setName(source.name);
        setPrice(source.price);
        setProductCategory(source.productCategory);
    }
    
    public abstract double calculateTaxes();
    public abstract Product clone();








    public Long getId() {
        return this.id;
    }
    public void setId(Long id){
        
        this.id = id;
    }

    

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price has to be greater than 0");
        }
        this.price = price;
    }

    public ProductCategory getProductCategory() {
        return this.productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        if (productCategory == null) {
            throw new IllegalArgumentException("Product category cannot be null");
        }
        this.productCategory = productCategory;
    }
    


}
