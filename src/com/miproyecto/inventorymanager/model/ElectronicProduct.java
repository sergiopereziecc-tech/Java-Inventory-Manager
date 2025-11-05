package com.miproyecto.inventorymanager.model;

public class ElectronicProduct extends Product{
    //Clase hija de la super clase Product
    //Activamos la herencia usando la palabra clave extends

    //Declaramos las variables unicas de esta clase
    private int warrantyMonths;
    //Declaramos constantes, variables que no van a ser modificadas
    //Usamos la palabra clave final, y private porque solos serán usadas en esta clase
    private static final int MIN_WARRANTY = 0;
    private static final double IVA_RATE = 0.18;

    
    //Constructor con todos los campos, los declarados aqui y en la super clase
    // Llama al constructor de la clase base y luego inicializa (y valida) los campos únicos.
    //Usamos la palabra super y llamamos a todos los campos heredados
    //Tiene que ir primero que las variables unicas de esta clase
    public ElectronicProduct(int warrantyMonths, Long id, String name, double price, ProductCategory productCategory){
        super(id, name, price, productCategory);
        setWarrantyMonths(warrantyMonths);
    }
    //Misma dinámica, mismo constructor pero sin el campo ID
    // Usamos 'super(name, ...)' para encadenar al constructor sin ID de la clase base, manteniendo el ID como nulo para la posterior asignación del Servicio.
    
    public ElectronicProduct(int warrantyMonths, String name, double price, ProductCategory productCategory){
        super(name, price, productCategory);
        setWarrantyMonths(warrantyMonths);
    }
    //Copy Constructor
    //Usamos la palabra super igual que en el constructor normal
    //Copy Constructor: Necesario para que el método clone() pueda crear copias profundas (Patrón Prototipo).
    public ElectronicProduct(ElectronicProduct source){
        super(source);
        setWarrantyMonths(source.warrantyMonths);
    }

    //Metodo Clone
    //Override de la clase abstracta
    //Creamos nuevo objeto del objeto que la llama(this) y lo devuelve
    @Override
    public Product clone() {
        return new ElectronicProduct(this);
    }
    //Metodo taxes
    //Override de la clase abstracta
    //Calcula los taxes y los devuelve
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
