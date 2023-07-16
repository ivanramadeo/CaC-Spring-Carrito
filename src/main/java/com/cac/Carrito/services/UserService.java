package com.cac.Carrito.services;

import com.cac.Carrito.entities.User;
import com.cac.Carrito.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Iterable<User> obtenerTodosUsuarios() {
        return repository.findAll();
    }

    public User obtenerUsuarioPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public User guardarUsuario(User user) {
        return repository.save(user);
    }

    public void eliminarUsuario(Long id) {
        repository.deleteById(id);
    }
}
