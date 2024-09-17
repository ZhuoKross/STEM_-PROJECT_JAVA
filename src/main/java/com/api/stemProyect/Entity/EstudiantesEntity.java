package com.api.stemProyect.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.swing.text.AbstractDocument;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "Estudiantes")
public class EstudiantesEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante", nullable = false)
    private Long id_estudiante;

    @Column(name = "nombres", nullable = false)
    private String nombres;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "contraseña", nullable = false)
    private String contraseña;

    @Column(name = "num_tutores")
    public Long num_tutores;

    @OneToOne(targetEntity = CarreraEntity.class)
    private CarreraEntity carrera;

    @ManyToMany(targetEntity = TutoriaEntity.class, fetch = FetchType.LAZY)
    @JoinTable(name = "estudiantes_tutoria", joinColumns =  @JoinColumn(name = "fk_estudiante_id"), inverseJoinColumns = @JoinColumn(name = "fk_tutoria_id"))
    private List<TutoriaEntity> tutoriaInscrita;

    @ManyToMany(targetEntity = ContentEntity.class, fetch = FetchType.LAZY)
    @JoinTable(name = "estudiante_contenido_favorito", joinColumns = @JoinColumn(name = "fk_estudiante_id"), inverseJoinColumns = @JoinColumn(name = "fk_content_id"))
    private List<ContentEntity> contenidoGuardado;

    private Set<ContentEntity> contenidos = new HashSet<>();


}
