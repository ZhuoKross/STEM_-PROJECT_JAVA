package com.api.stemProyect.Business;


import com.api.stemProyect.Dto.ContentDTO;
import com.api.stemProyect.Entity.ContentEntity;
import com.api.stemProyect.Service.ContentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class SaveContentBusiness {

    @Autowired
    ContentService contentService;
    ModelMapper modelMapper = new ModelMapper();

    public List<ContentDTO> findAll(){
        try{

            List<ContentEntity> contentEntities = contentService.findAll();
            List<ContentDTO> contentDTOList = new ArrayList<>();

            for(ContentEntity content : contentEntities){
                contentDTOList.add(modelMapper.map(content, ContentDTO.class));
            }

            return contentDTOList;


        }catch (Exception e){
            throw new Error("Error al obtener contenidos(Business)", e);
        }
    }


    public void create(ContentDTO contentDTO){
        try{

            ContentEntity content = modelMapper.map(contentDTO, ContentEntity.class);

            contentService.save(content);


        }catch (Exception e){
            throw new Error("Error al Guardar contenido(Business)", e);
        }
    }

    public void update(Long id,ContentDTO contentDTO){
        try {

            //System.out.println("El id es: " + id);

            ContentEntity contentEntity = contentService.getById(id);


            contentEntity.setAuthor(contentDTO.getAuthor());
            contentEntity.setJournal(contentDTO.getJournal());
            contentEntity.setLink(contentDTO.getLink());
            contentEntity.setSummary(contentDTO.getSummary());
            contentEntity.setTitle(contentDTO.getTitle());



            contentService.update(contentEntity);

        }catch (Exception e){
            throw new Error("Error al actualizar contenido (Business)", e);
        }
    }


    public void delete(ContentEntity content){
        try {

            contentService.delete(content);

        }catch (Exception e){
            throw new Error("Error al eliminar contenido (Business):", e);
        }
    }

}
