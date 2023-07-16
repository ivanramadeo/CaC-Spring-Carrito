package com.cac.Carrito.controllers;


import com.cac.Carrito.entities.Producto;
import com.cac.Carrito.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;




@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService service;

    @Autowired
    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping("/vista")
    public String obtenerTodosProductos(Model model) {
        Iterable<Producto> productos = service.obtenerTodosProductos();
        model.addAttribute("productos", productos);
        return "productos";
    }

    @GetMapping("/listar")
    public Iterable<Producto> obtenerTodosProductosApi() {
        return service.obtenerTodosProductos();
    }

    @GetMapping("/mostrar/{id}")
    public Producto obtenerProductoPorId(@PathVariable Long id) {
        return service.obtenerProductoPorId(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        service.eliminarProducto(id);
    }
    @PostMapping("/nuevo")
    public Producto crearProducto(@RequestBody Producto producto) {

        return service.guardarProducto(producto);
    }
}
