package com.api.stemProyect.Business;

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
}