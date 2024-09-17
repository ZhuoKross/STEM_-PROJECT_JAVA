package com.api.stemProyect.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Carrera")
public class CarreraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrera")
    private Long idCarrera;

    @Column(name = "nombre_carrera")
    private String nombreCarrera;

    @Column(name = "n_estudiantes")
    private byte nEstudiantes;

    @Column(name = "n_profesores")
    private byte nProfesores;

}
