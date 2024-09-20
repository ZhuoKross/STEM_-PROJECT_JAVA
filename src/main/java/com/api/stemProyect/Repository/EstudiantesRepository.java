package com.api.stemProyect.Repository;

import com.api.stemProyect.Entity.ContentEntity;
import com.api.stemProyect.Entity.EstudiantesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EstudiantesRepository extends JpaRepository<EstudiantesEntity, Long>{

    @Query("SELECT c FROM EstudiantesEntity e JOIN e.contenidoGuardado c WHERE e.id_estudiante = :id")
    public List<ContentEntity> findAssociatedContents(Long id);
}


