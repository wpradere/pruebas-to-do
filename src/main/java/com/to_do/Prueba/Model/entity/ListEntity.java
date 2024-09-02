package com.to_do.Prueba.Model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;



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

//    @ManyToOne(fetch = FetchType.LAZY )
//    @JoinColumn (name = "iduser")
//    private UserEntity user;


}
