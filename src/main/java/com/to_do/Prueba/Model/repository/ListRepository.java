package com.to_do.Prueba.Model.repository;

import com.to_do.Prueba.Model.entity.ListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ListRepository extends JpaRepository<ListEntity,Long> {

        List<ListEntity> findByIdUser (Long id_user);

}
