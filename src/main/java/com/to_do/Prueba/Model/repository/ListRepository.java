package com.to_do.Prueba.Model.repository;

import com.to_do.Prueba.Model.entity.ListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository<ListEntity,Long> {
}
