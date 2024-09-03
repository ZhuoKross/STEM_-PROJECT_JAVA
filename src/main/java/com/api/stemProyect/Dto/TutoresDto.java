package com.api.stemProyect.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TutoresDto {
    private Long id_tutor;
    private String nombres;
    private String apellidos;
    private String email;
    private String contraseña;
    private Long num_estudiantes;
}
