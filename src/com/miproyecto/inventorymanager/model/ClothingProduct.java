package com.miproyecto.inventorymanager.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ClothingProduct extends Product {
    //Clase hija de Producto, declaramos con la keyword extends

    //Enum tallas, libre de validaciones, mejor legibilidad
    public enum Size{
        XS, S, M, L, XL, XXL
    }
    //Variable necesaria para usar el enum
    private Size size;

    //Enum materiales, libre de validaciones, mejor legibilidad, constante, buen mantenimiento
    public enum Material{
        COTTON, WOOL, POLYESTER, SILK, LEATHER
    }
    //Variable necesaria para usar el enum
    private Material material;

    //Constante IVA que no se modifica
    private static final BigDecimal IVA_RATE = new BigDecimal("0.23");

    //Constructor de la clase ClothingProduct con todos sus campos
    //Hereda de la superclase, usando el keyword super
    public ClothingProduct(Long id, String name, BigDecimal price , ProductCategory productCategory,Size size, Material material){
        super(id, name, price, productCategory);
        this.size = size;
        this.material = material;
    }
    //Constructor con todos los campos menos ID
    //Creamos ID aleatorio en service
    public ClothingProduct(String name, BigDecimal price, ProductCategory productCategory,Size size, Material material){
        super(name, price, productCategory);
        this.size = size;
        this.material = material;
    }
    //Constructor copia necesario para el metodo clone()
    public ClothingProduct(ClothingProduct source){
        super(source);
        this.size = source.size;
        this.material = source.material;
    }
    //Override del metodo clone, creado en la clase abstracta Product
    //Creamos una copia profunda del objeto en concreto que llame a este metodo
    @Override
    public Product clone() {
        return new ClothingProduct(this);
    }
    //Override del metodo calculateTaxes, creado en la clase abstracta Product
    //Calcula los impuestos
    @Override
    public BigDecimal  calculateTaxes() {
        BigDecimal taxAmount = getPrice().multiply(IVA_RATE);
        return taxAmount.setScale(2, RoundingMode.HALF_UP);
    }

    //GETTERS AND SETTERS

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
