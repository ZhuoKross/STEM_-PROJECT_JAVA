package com.api.stemProyect.Business;


import com.api.stemProyect.Service.EstudiantesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class SaveContentBusiness {

    @Autowired
    EstudiantesService estudiantesService;
    ModelMapper modelMapper = new ModelMapper();



}
