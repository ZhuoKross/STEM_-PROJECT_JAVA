package com.api.stemProyect.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.AllArgsConstructor;


@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EstudiantesDto {
    private Long id;
    private String nombres;
    private  String apellidos;
    private String email;
    private String contraseña;
}
