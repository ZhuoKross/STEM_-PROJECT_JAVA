package com.api.stemProyect.Service;

import com.api.stemProyect.Entity.ContentEntity;
import com.api.stemProyect.Entity.EstudiantesEntity;
import com.api.stemProyect.Repository.ContenRepository;
import com.api.stemProyect.Repository.EstudiantesRepository;
import com.api.stemProyect.Service.Dao.Idao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class EstudiantesService implements Idao<EstudiantesEntity, Long>{

    @Autowired
    EstudiantesRepository estudiantesRepository;
    ContenRepository contenRepository;

    @Override
    public List<EstudiantesEntity> findAll() {
        return estudiantesRepository.findAll();
    }

    @Override
    public EstudiantesEntity getById(Long id){
        Optional<EstudiantesEntity> optionalEstudiantesEntity = estudiantesRepository.findById(id);
        return optionalEstudiantesEntity.orElse(null);
    }

    @Override
    public void update(EstudiantesEntity entity){
        this.estudiantesRepository.save(entity);
    }

    @Override
    public void save(EstudiantesEntity entity){
        this.estudiantesRepository.save(entity);
    }

    @Override
    public void delete(EstudiantesEntity entity){
        this.estudiantesRepository.delete(entity);
    }

    @Override
    public void create(EstudiantesEntity entity){
        this.estudiantesRepository.save(entity);
    }

    // Para la operación de Guardar contenidos Favoritos
    public void saveContent (long idUser, Long idContent){

        EstudiantesEntity estudiante = estudiantesRepository.findById(idUser).orElseThrow();
        ContentEntity content = contenRepository.findById(idContent).orElseThrow();

        estudiante.getContenidos().add(content);
        estudiantesRepository.save(estudiante);

    }

}
