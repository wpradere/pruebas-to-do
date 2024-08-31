package com.to_do.Prueba.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ResponUpdateTask {
    public Long id;
    public String name_list;
    public String state;
    public LocalDate date_start;
    public LocalDate date_update;
}
