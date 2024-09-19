package com.api.stemProyect.Controller;

import com.api.stemProyect.Business.SaveContentBusiness;
import com.api.stemProyect.Dto.ContentDTO;
import com.api.stemProyect.Entity.ContentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( path = "api/contents", method = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@CrossOrigin(origins = "*")
public class ContentController {

    @Autowired
    SaveContentBusiness saveContentBusiness;

    @GetMapping("/all")
    public List<ContentDTO> getAll() {return saveContentBusiness.findAll();}

    @PostMapping("/create")
    public void create(@RequestBody ContentDTO contentDTO){


        String idArticle = contentDTO.getId();
        String authorArticle = contentDTO.getAuthor();
        String summaryArticle = contentDTO.getSummary();
        String linkArticle = contentDTO.getLink();
        String titleArticle = contentDTO.getTitle();
        String journalArticle = contentDTO.getJournal();


        System.out.println("id: " + idArticle);
        System.out.println("author: " + authorArticle);
        System.out.println("summary: " + summaryArticle);
        System.out.println("link: " + linkArticle);
        System.out.println("title: " + titleArticle);
        System.out.println("journal: " + journalArticle);




        saveContentBusiness.create(contentDTO);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable String id,@RequestBody ContentDTO contentDTO){saveContentBusiness.update(id,contentDTO);}

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") ContentEntity contentEntity){saveContentBusiness.delete(contentEntity);}
}
