package com.api.stemProyect.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Tutoria")
public class TutoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tutoria")
    private  Long idTutoria;

    @Column(name = "nombre_tutoria")
    private String nombreTutoria;


    private String carrera;

    @Column(name = "n_plazas")
    private byte nPlazas;


}
