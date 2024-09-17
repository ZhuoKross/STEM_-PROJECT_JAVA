package com.api.stemProyect.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveContentDTO {

    private Long id_estudiante;
    private Long id_content;

}
