package com.api.stemProyect.Controller;


import com.api.stemProyect.Business.EstudiantesBusiness;
import com.api.stemProyect.Dto.EstudiantesDto;
import com.api.stemProyect.Entity.EstudiantesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {
    @Autowired
    EstudiantesBusiness estudiantesBusiness;

    @GetMapping("/all")
    public List<EstudiantesDto> getAll(){
        return estudiantesBusiness.findAll();
    }

    @PostMapping("/create")
    public void create(@RequestBody EstudiantesDto estudiantesDto){


        //estudiantesBusiness.create(estudiantesDto);
    }

    @PutMapping("/update")
    public void update(@RequestBody EstudiantesDto estudiantesDto){
        estudiantesBusiness.update(estudiantesDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOne(@PathVariable("id")EstudiantesEntity entity){
        estudiantesBusiness.delete(entity);
    }

}
