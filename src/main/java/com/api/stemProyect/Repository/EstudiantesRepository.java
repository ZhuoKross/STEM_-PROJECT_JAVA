package com.api.stemProyect.Repository;

import com.api.stemProyect.Entity.EstudiantesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EstudiantesRepository extends JpaRepository<EstudiantesEntity, Long>{
}


