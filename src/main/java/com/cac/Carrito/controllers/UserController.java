package com.cac.Carrito.controllers;


import com.cac.Carrito.entities.User;
import com.cac.Carrito.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/vista")
    public String obtenerTodosUsuarios(Model model) {
        Iterable<User> usuarios = service.obtenerTodosUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "usuarios";
    }

    @GetMapping("/listar")
    public Iterable<User> obtenerTodosUsuariosApi() {
        return service.obtenerTodosUsuarios();
    }
    @PostMapping("/nuevo")
    public User crearUsuario(@RequestBody User user) {
        return service.guardarUsuario(user);
    }
}
