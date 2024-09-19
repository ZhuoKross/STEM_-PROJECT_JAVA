package com.api.stemProyect.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Content")
public class ContentEntity {

    @Id
    private String id;

    private String title;

    private String link;

    private String journal;

    @Column(name = "summary", length = 500)
    private String summary;

    private String author;

    @ManyToMany(mappedBy = "contenidoGuardado")

    private Set<EstudiantesEntity> estudiantes = new HashSet<>();

}
