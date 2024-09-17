package com.api.stemProyect.Controller;


import com.api.stemProyect.Business.EstudiantesBusiness;
import com.api.stemProyect.Dto.EstudiantesDto;
import com.api.stemProyect.Entity.EstudiantesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/estudiantes",method = {RequestMethod.DELETE,RequestMethod.GET})
@CrossOrigin(origins = "*")
public class EstudianteController {
    @Autowired
    EstudiantesBusiness estudiantesBusiness;

    @GetMapping("/all")
    public List<EstudiantesDto> getAll(){
        return estudiantesBusiness.findAll();
    }

    @PostMapping("/create")
   // @CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.POST})
    public void create(@RequestBody EstudiantesDto estudiantesDto){

        //String nombreEstudiante = estudiantesDto.getNombres();
        //String apellidoEstudiante = estudiantesDto.getApellidos();
        //String emailEstudiante = estudiantesDto.getEmail();
        //String passwordEstudiante = estudiantesDto.getContraseña();

        // VALIDACIÓN DE LA OBTENCIÓN DE LOS DATOS
        //System.out.println("Nombre: " + nombreEstudiante);
        //System.out.println("Apellido: " + apellidoEstudiante);
        //System.out.println("Email: " + emailEstudiante);
        //System.out.println("password: " + passwordEstudiante);



        estudiantesBusiness.create(estudiantesDto);
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
