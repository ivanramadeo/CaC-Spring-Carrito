package com.cac.Carrito.services;

import com.cac.Carrito.entities.Producto;
import com.cac.Carrito.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    @Autowired
    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public Iterable<Producto> obtenerTodosProductos() {
        return repository.findAll();
    }

    public Producto obtenerProductoPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Producto guardarProducto(Producto producto) {
        return repository.save(producto);
    }

    public void eliminarProducto(Long id) {
        repository.deleteById(id);
    }
}

