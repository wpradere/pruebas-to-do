package com.to_do.Prueba.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RequestTask {
   public String name_list;
   public String state;
   public Long id_user;
}
