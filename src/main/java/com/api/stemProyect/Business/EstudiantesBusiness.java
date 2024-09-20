package com.api.stemProyect.Business;


import com.api.stemProyect.Dto.AssociateContentDTO;
import com.api.stemProyect.Dto.ContentDTO;
import com.api.stemProyect.Entity.ContentEntity;
import com.api.stemProyect.Service.ContentService;
import com.api.stemProyect.Service.EstudiantesService;
import com.api.stemProyect.Dto.EstudiantesDto;
import com.api.stemProyect.Entity.EstudiantesEntity;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Component
public class EstudiantesBusiness {

    @Autowired
    private EstudiantesService estudiantesService;

    @Autowired
    private ContentService contentService;
    private final ModelMapper modelMapper = new ModelMapper();

    public List<EstudiantesDto> findAll(){
        try{
            List<EstudiantesEntity> estudiantesEntity = estudiantesService.findAll();
            List<EstudiantesDto> estudiantesDtoList = new ArrayList<EstudiantesDto>();

            for(EstudiantesEntity estudiante : estudiantesEntity){
                estudiantesDtoList.add(modelMapper.map(estudiante, EstudiantesDto.class));
            }

            return estudiantesDtoList;

        }catch (Exception e){
            throw new Error("Error al obtener la lista de estudiantes", e);
        }
    }


    public List<ContentDTO> findAssociatedContents (Long id){
        try{

            List<ContentEntity> contentEntityList = estudiantesService.findAssociatedContents(id);
            List<ContentDTO> contentDTOList = new ArrayList<>();

            for (ContentEntity content : contentEntityList){
                contentDTOList.add(modelMapper.map(content, ContentDTO.class));
            }


            return contentDTOList;


        }catch (Exception e){
            throw new Error("Error al traer contenidos Asociados (Business): ", e);
        }
    }



    public void create(EstudiantesDto estudiantesDto){
        try{
            EstudiantesEntity estudiante = modelMapper.map(estudiantesDto, EstudiantesEntity.class);
            estudiantesService.save(estudiante);

        }catch (Exception e){
            throw new Error("Error al crear Estudiante", e);
        }
    }

    public void update(EstudiantesDto estudiantesDto){
        try{
            EstudiantesEntity estudiante = modelMapper.map(estudiantesDto, EstudiantesEntity.class);
            estudiantesService.update(estudiante);

        } catch (Exception e) {
            throw new Error("Error al actualizar Estudiante", e);
        }
    }

    public void delete(EstudiantesEntity entity){
        try{
            estudiantesService.delete(entity);
        } catch (Exception e) {
            throw new Error("Error al eliminar Estudiante", e);
        }
    }


    public void saveContent(AssociateContentDTO associateContentDTO){
        try{

            Long id_estudiante = associateContentDTO.getId_estudiante();
            String id_content = associateContentDTO.getId_content();

            EstudiantesEntity estudiantesEntity = estudiantesService.getById(id_estudiante);
            ContentEntity contentEntity = contentService.getById(id_content);

            estudiantesEntity.getContenidoGuardado().add(contentEntity);

            estudiantesService.save(estudiantesEntity);


        }catch (Exception e){
            throw new Error("Error al guardar Content(business)", e);
        }
    }
}
