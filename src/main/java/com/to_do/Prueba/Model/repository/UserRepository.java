package com.to_do.Prueba.Model.repository;

import com.to_do.Prueba.Model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
