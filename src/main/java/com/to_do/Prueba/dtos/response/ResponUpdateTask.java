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
    public Long idList;
    public String nameList;
    public String state;
    public LocalDate dateStart;
    public LocalDate dateUpdate;
}
