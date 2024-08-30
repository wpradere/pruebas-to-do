package com.to_do.Prueba.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ResponseUser {
    private Long id;
    private String fullName;
    private String userName;
    private String password;
}
