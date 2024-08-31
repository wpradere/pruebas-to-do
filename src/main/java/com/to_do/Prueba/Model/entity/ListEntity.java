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
    @Column(name = "id_list")
    private Long idList;
    @Column(name = "name_list")
    private String nameList;
    private String state;
    @Column(name = "id_user")
    private Long idUser;
    @Column(name = "date_start")
    private LocalDate dateStart;
    @Column(name = "date_update")
    private LocalDate dateUpdate;



}
