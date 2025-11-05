package com.miproyecto.inventorymanager.model;

public class ClothingProduct extends Product {
    public enum Size{
        XS, S, M, L, XL, XXL
    }
    private Size size;
    public enum Material{
        COTTON, WOOL, POLYESTER, SILK, LEATHER
    }
    private Material material;
    private static double IVA_RATE = 0.23;

    public ClothingProduct(Long id, String name, double price, ProductCategory productCategory,Size size, Material material){
        super(id, name, price, productCategory);
        this.size = size;
        this.material = material;
    }
    public ClothingProduct(String name, double price, ProductCategory productCategory,Size size, Material material){
        super(name, price, productCategory);
        this.size = size;
        this.material = material;
    }
    public ClothingProduct(ClothingProduct source){
        super(source);
        this.size = source.size;
        this.material = source.material;
    }
    @Override
    public Product clone() {
        return new ClothingProduct(this);
    }
    @Override
    public double calculateTaxes() {
        return getPrice() * IVA_RATE;
    }


    public Size getSize() {
        return this.size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Material getMaterial() {
        return this.material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

}
