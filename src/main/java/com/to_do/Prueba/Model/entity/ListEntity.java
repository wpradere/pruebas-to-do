package com.to_do.Prueba.Model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity(name ="list" )
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ListEntity {

    @Id
    private Long id_list;
    private String name_list;
    private Long id_user;
    private LocalDate date_start;
    private LocalDate date_update;


}
