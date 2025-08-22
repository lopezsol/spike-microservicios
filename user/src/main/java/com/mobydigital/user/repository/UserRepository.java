package com.mobydigital.user.repository;

import com.mobydigital.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// Repositorio para la entidad User (hace las consultas a la base de datos)
public interface UserRepository extends JpaRepository<User, Long> {
}
