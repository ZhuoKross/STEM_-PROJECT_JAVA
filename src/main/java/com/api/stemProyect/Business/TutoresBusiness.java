package com.api.stemProyect.Business;

import com.api.stemProyect.Dto.TutoresDto;
import com.api.stemProyect.Entity.TutoresEntity;
import com.api.stemProyect.Service.TutorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.ArrayList;


@Component
public class TutoresBusiness {
    @Autowired
    TutorService tutorService;
    ModelMapper modelMapper = new ModelMapper();

    public List<TutoresDto> finAll(){
        try{
            List<TutoresEntity> tutoresEntityList = tutorService.findAll();
            List<TutoresDto> tutoresDtoList = new ArrayList<TutoresDto>();

            for(TutoresEntity tutor : tutoresEntityList){
                tutoresDtoList.add(modelMapper.map(tutor, TutoresDto.class));
            }

            return tutoresDtoList;

        }catch (Exception e){
            throw new Error("Error al obtener todos los tutores", e);
        }
    }

    public void create(TutoresDto tutoresDto){
        try{

            TutoresEntity tutorEntity = modelMapper.map(tutoresDto, TutoresEntity.class);
            tutorService.create(tutorEntity);

        } catch (RuntimeException e) {
            throw new RuntimeException("Error al crear tutor", e);
        }
    }

    public void update(TutoresDto tutoresDto){
        try{

            TutoresEntity tutorEntity = modelMapper.map(tutoresDto, TutoresEntity.class);
            tutorService.update(tutorEntity);

        }catch (RuntimeException e){
            throw new RuntimeException("Error al actualizar tutor", e);
        }
    }

    public void delete(TutoresEntity entity){
        try{
            tutorService.delete(entity);
        }catch (RuntimeException e){
            throw new RuntimeException("Error al eliminar tutor", e);
        }
    }

}
