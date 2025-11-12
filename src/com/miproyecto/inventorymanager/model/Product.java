package com.miproyecto.inventorymanager.model;

import java.math.BigDecimal;

public abstract class Product {

    //Product es la superclase, las clases hijas heredan de aqui variables y metodos
    //Es abstracta por lo que no se puede crear un objeto a partir de ella

    //Definimos las variables que se usan en todos nuestros Productos

    private Long id;
    private String name;
    private BigDecimal price;
    private ProductCategory productCategory;

    //Creación de constructor con todos los campos
    //Creación previa de los setters para manejar exceptions, DRY coding sin repetición
    public Product(Long id, String name, BigDecimal price, ProductCategory productCategory) {
        setId(id);
        setName(name);
        setPrice(price);
        setProductCategory(productCategory);
    }
    //Creamos constructor sin ID, ya que posteriormente tendremos un metodo para crear ID de objetos nuevos
    // Usamos 'this(null, ...)' para encadenar al constructor principal y reutilizar sus validaciones.
    //null, ya que no tenemos id pero nuestro metodo save se ocupara de eso despues
    public Product(String name, BigDecimal price , ProductCategory productCategory){
        this(null, name, price, productCategory);
    }
    //Copy Constructor
    // Copy Constructor: Necesario para implementar la clonación segura (Patrón Prototipo).
    public Product(Product source){
        this.id = source.id;
        setName(source.name);
        setPrice(source.price);
        setProductCategory(source.productCategory);
    }

    //Metodos abstractos que simplemente nos obligan a crearlos en las otras clases
    //CalculateTaxes para calcular los impuestos de los productos
    //Metodo Clone para generar deep copys
    //Metodo Clone: Implementa el Patrón Prototipo, creando una copia profunda del objeto.
    public abstract BigDecimal calculateTaxes();
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

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO)<= 0) {
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
