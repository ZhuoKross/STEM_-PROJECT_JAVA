package com.api.stemProyect.Controller;

import com.api.stemProyect.Business.TutoresBusiness;
import com.api.stemProyect.Dto.TutoresDto;
import com.api.stemProyect.Entity.TutoresEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tutores")
public class TutorController {
    @Autowired
    TutoresBusiness tutoresBusiness;

    @GetMapping("/all")
    public List<TutoresDto> getAll(){
        return tutoresBusiness.finAll();
    }

    @PostMapping("/create")
    public void create(@RequestBody TutoresDto tutoresDto){
        tutoresBusiness.create(tutoresDto);
    }

    @PutMapping("/update")
    public void update(@RequestBody TutoresDto tutoresDto){
        tutoresBusiness.update(tutoresDto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete (@PathVariable("id") TutoresEntity entity){
        tutoresBusiness.delete(entity);
    }
}
