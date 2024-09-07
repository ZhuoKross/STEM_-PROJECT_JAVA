package com.api.stemProyect.Service;


import com.api.stemProyect.Entity.TutoresEntity;
import com.api.stemProyect.Repository.TutoresRepository;
import com.api.stemProyect.Service.Dao.Idao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;


@Service
public class TutorService implements Idao<TutoresEntity, Long>{
    @Autowired
    TutoresRepository tutoresRepository;

    @Override
    public List<TutoresEntity> findAll(){
        return tutoresRepository.findAll();
    }

    @Override
    public TutoresEntity getById(Long id){
        Optional<TutoresEntity> optionalTutoresEntity = tutoresRepository.findById(id);
        return optionalTutoresEntity.orElse(null);
    }

    @Override
    public void update(TutoresEntity entity){
        this.tutoresRepository.save(entity);
    }

    @Override
    public void save(TutoresEntity entity){
        this.tutoresRepository.save(entity);
    }

    @Override
    public void delete(TutoresEntity entity){
        this.tutoresRepository.delete(entity);
    }

    @Override
    public void create(TutoresEntity entity){
        this.tutoresRepository.save(entity);
    }
}
