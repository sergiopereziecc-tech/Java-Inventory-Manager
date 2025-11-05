package com.miproyecto.inventorymanager.app;

import com.miproyecto.inventorymanager.model.ElectronicProduct;
import com.miproyecto.inventorymanager.model.ProductCategory;
import com.miproyecto.inventorymanager.service.InMemoryProductService;

public class Main {
    public static void main(String[] args) {
        InMemoryProductService service = new InMemoryProductService();

        ElectronicProduct ordenador = new ElectronicProduct(3, "Ordenador", 300, ProductCategory.ELECTRONICS);
        service.save(ordenador);
        Long idAsignado = ordenador.getId();

        ElectronicProduct copyOrdenador = (ElectronicProduct) service.findById(idAsignado);
        copyOrdenador.setPrice(23000);

        ElectronicProduct ordenadorInventario = (ElectronicProduct) service.findById(idAsignado);

        System.out.println("ID del Producto: " + idAsignado);
        System.out.println("Precio de la Copia Modificada: " + copyOrdenador.getPrice()); // Debe ser 1000.00
        System.out.println("Precio Original en Inventario: " + ordenadorInventario.getPrice()); // Debe ser 300.00
    }

}
