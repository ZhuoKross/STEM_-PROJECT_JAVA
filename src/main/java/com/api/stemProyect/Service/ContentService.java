package com.api.stemProyect.Service;

import com.api.stemProyect.Entity.ContentEntity;
import com.api.stemProyect.Repository.ContenRepository;
import com.api.stemProyect.Service.Dao.Idao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentService{
    @Autowired
    ContenRepository contenRepository;


    public List<ContentEntity> findAll (){
        return contenRepository.findAll();
    }


    public ContentEntity getById(String idContent) {
        Optional<ContentEntity> optionalContent = contenRepository.findById(idContent);
        return  optionalContent.orElse(null);
    }


    public void update(ContentEntity entity) {
        contenRepository.save(entity);
    }


    public void save(ContentEntity entity) {
        contenRepository.save(entity);
    }


    public void delete(ContentEntity entity) {
        contenRepository.delete(entity);
    }


    public void create(ContentEntity entity) {
        contenRepository.save(entity);
    }


}
