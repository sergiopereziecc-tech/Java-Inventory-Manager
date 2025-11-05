package com.miproyecto.inventorymanager.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.miproyecto.inventorymanager.model.Product;

public class InMemoryProductService {
    private final HashMap<Long, Product> inventory = new HashMap<>();
    // Variable para asignar id aleatorios a los productos
    private Long nextId = 1L;

    // Metodos CRUD ESENCIALES

    // Metodo para guardar un producto nuevo, asignandole un id
    public Product save(Product product) {

        // 1. Decisión de ID
        if (product.getId() == null) {
            // Si es nuevo: Asignamos el ID y preparamos el contador para el futuro.
            product.setId(nextId);
            nextId++;
        }
        // Si no es null, es una actualización y procedemos a guardar usando el ID
        // existente.

        // 2. Guardar
        // Usamos el ID asignado (creación) o existente (actualización) como clave.
        this.inventory.put(product.getId(), product);

        // 3. Retorno
        return product;
    }

    // Metodo para encontrar un objeto usando un parametro ID.
    public Product findById(Long id) {
        // 1.Creamos variable temporal
        // Guardamos id, usando metodo get del Hashmap
        Product foundProduct = this.inventory.get(id);
        // Estructura if para validar que no sea nulo, y nos lance un error
        // Comparamos variable donde hemos guardado id
        // Si es null, devuelve null
        if (foundProduct == null) {
            return null;
        }
        // Si no es null, pasa al siguiente bloque
        // devolvemos variable temporal clonada, usando metodo clone
        // ya que no devolvemos nunca objeto original
        return foundProduct.clone();
    }

    // Metodo para devolver todos los productos en una lista
    public List<Product> findAll() {
        // Queremos devolver una lista con todos los productos que tenemos
        // Creamos una ArrayList vacia, que sera la que vamos a devolver
        ArrayList<Product> allProducts = new ArrayList<>();
        // Iteramos sobre los productos que tenemos guardados en el hashmap
        // Para ello, usamos .values()
        // Usamos metodo add para añadir los Productos a nuestra nueva lista
        // Por seguridad, tenemos que devolver copias de todos los objetos y no
        // originales
        // Usamos clone() con todos los Productos que vamos añadiendo
        for (Product product : this.inventory.values()) {
            allProducts.add(product.clone());
        }
        // Devolvemos la lista
        return allProducts;

        // Mismo metodo pero realizado con el otro for
        // ArrayList<Product> allProducts = new ArrayList<>(this.inventory.values());
        // for (int i = 0; i < allProducts.size(); i++) {

        // allProducts.set(i, allProducts.get(i).clone());
        // }

    }

    // Metodo usado para borrar un objeto de nuestro hashmap usando su id
    public void delete(Long id) {
        // Usamos .remove con su id para borrar
        this.inventory.remove(id);
    }
}
