package com.to_do.Prueba.Model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private Long id;
    private String fullName;
    private String userName;
    private String password;

}
