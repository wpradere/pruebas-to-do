package com.to_do.Prueba.Model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name ="user_todo" )
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;

}
