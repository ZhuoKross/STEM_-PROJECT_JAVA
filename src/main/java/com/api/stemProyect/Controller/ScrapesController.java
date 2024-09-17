package com.api.stemProyect.Controller;

import com.api.stemProyect.Dto.ArticlePubMedDTO;
import com.api.stemProyect.Service.Scrapes.ScrapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.api.stemProyect.Dto.SearchTermDTO;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping(path = "api/scrapes", method = {RequestMethod.GET, RequestMethod.POST})
@CrossOrigin(origins = "*")
public class ScrapesController {


    @Autowired
    ScrapeService scrapeService;



    @PostMapping("/search")
    public List<ArticlePubMedDTO> getArticles(@RequestBody SearchTermDTO searchTerm) throws IOException {

        String search = searchTerm.getSearchTerm();
        String FormattedSearch = search.replace(" ","+");

        System.out.println("Término de Búsqueda: "+  FormattedSearch);

        return scrapeService.scrapePubMed(FormattedSearch);
    }

}
