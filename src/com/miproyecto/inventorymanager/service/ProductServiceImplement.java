package com.miproyecto.inventorymanager.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.miproyecto.inventorymanager.model.Product;

public class ProductServiceImplement implements ProductService{
    //Variables: Hashmap<Key,value>
    private final HashMap<Long, Product> inventory = new HashMap<>();
    private Long nextId = 1L;
    //Metodo save, devuelve un objeto(Product)
    //Parametro: un objeto(Product)
    public Product save(Product product) {
        //Creamos una copia, que guardamos en una variable
        Product cloneProduct = product.clone();
        
        if (cloneProduct.getId() == null) { // Si es null significa que no tiene id
            cloneProduct.setId(nextId); // Asignación Id
            nextId++; // Aumento contador ID, no repetición ID
        }
        //Usamos put para colocar nuestra copia en el hashmap
        //Obtenemos el id, usando getter
        this.inventory.put(cloneProduct.getId(), cloneProduct);
        //Devolvemos el objeto
        return cloneProduct;
    }
    //Metodo para encontrar producto por ID
    //Devolvemos un Optional, puede que exista o si no devuelve objeto vacio
    //Evitamos problemas con null
    public Optional<Product> findById(Long id) {
        //Guardamos en una variable el producto a encontrar usando getter
        Product foundProduct = this.inventory.get(id);
        //Devolvemos copia Optional
        //ofNullable devuelve el objeto si existe
        //Si no existe devuelve un objeto vacio
        //.map lambda para clonar el objeto y devolver una copia
        return Optional.ofNullable(foundProduct)
                .map(product -> foundProduct.clone());

    }
    //Metodo para encontrar todos los valores de nuestra lista
    //Devolvemos una lista con objetos
    public List<Product> findAll() {
        //values() nos da todos los valores de la lista
        //Convertimos esos valores en una cadena de montaje, usando stream
        //map para crear copias profundas de todos los productos
        //to list para organizarlos en una lista
        return this.inventory.values().stream()
                .map(product -> product.clone())
                .toList();
    }
    //Metodo para borrar un objeto en base a su id
    //Optional para devolver el objeto borrado por si se necesita
    //Si existe lo devuelve, si no devuelve objeto vacio
    //Evitamos problemas con null
    public Optional<Product> delete(Long id){
        //Guardamos objeto borrado en una variable
        Product removeProduct = this.inventory.remove(id);
        //Devolvemos objeto borrado
        //Comprobamos con ofNullable si es null o no
        //Si es null devuelve objeto vacio
        return Optional.ofNullable(removeProduct);
            
    }
}
