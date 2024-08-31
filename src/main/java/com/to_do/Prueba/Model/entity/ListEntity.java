package com.to_do.Prueba.Model.entity;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_list;
    private String name_list;
    private String state;
    private Long id_user;
    private LocalDate date_start;
    private LocalDate date_update;



}
