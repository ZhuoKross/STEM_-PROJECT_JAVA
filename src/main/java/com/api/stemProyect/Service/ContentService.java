package com.api.stemProyect.Service;

import com.api.stemProyect.Entity.ContentEntity;
import com.api.stemProyect.Repository.ContenRepository;
import com.api.stemProyect.Service.Dao.Idao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentService implements Idao<ContentEntity, Long> {
    @Autowired
    ContenRepository contenRepository;

    @Override
    public List<ContentEntity> findAll (){
        return contenRepository.findAll();
    }

    @Override
    public ContentEntity getById(Long idContent) {
        Optional<ContentEntity> optionalContent = contenRepository.findById(idContent);
        return  optionalContent.orElse(null);
    }

    @Override
    public void update(ContentEntity entity) {
        contenRepository.save(entity);
    }

    @Override
    public void save(ContentEntity entity) {
        contenRepository.save(entity);
    }

    @Override
    public void delete(ContentEntity entity) {
        contenRepository.delete(entity);
    }

    @Override
    public void create(ContentEntity entity) {
        contenRepository.save(entity);
    }


}
