package com.cac.Carrito.repository;

import com.cac.Carrito.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

