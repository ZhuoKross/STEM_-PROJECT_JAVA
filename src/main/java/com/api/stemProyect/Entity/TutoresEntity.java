package com.api.stemProyect.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "Tutores")
public class TutoresEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tutor", nullable = false)
    private Long id_tutor;

    @Column(name = "nombres", nullable = false)
    private String nombres;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "contraseña", nullable = false)
    private String contraseña;

    @Column(name = "num_estudiantes")
    public Long num_estudiantes;

    @ManyToMany(targetEntity = TutoriaEntity.class, fetch = FetchType.LAZY)
    @JoinTable(name = "profesor_tutoria", joinColumns = @JoinColumn(name = "fk_profesor_id"), inverseJoinColumns = @JoinColumn(name = "fk_tutoria_id"))
    private List<TutoresEntity> tutoriaACargo;

    @ManyToMany(targetEntity = CarreraEntity.class, fetch = FetchType.LAZY)
    @JoinTable(name = "profesor_carrera", joinColumns = @JoinColumn(name = "fk_profesor_id"), inverseJoinColumns = @JoinColumn(name = "fk_carrera_id"))
    private List<CarreraEntity> carreraImpartida;
}
