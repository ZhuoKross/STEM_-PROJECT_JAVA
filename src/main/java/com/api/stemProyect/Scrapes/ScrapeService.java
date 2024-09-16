package com.api.stemProyect.Scrapes;

import org.jsoup.Jsoup;
import com.api.stemProyect.Dto.ArticlePubMedDTO;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

@Component
public class ScrapeService {

    public List<ArticlePubMedDTO> scrapePubMed(String SearchTerm) throws IOException {

        List<ArticlePubMedDTO> listArticles = new ArrayList<>();
        String url = "https://pubmed.ncbi.nlm.nih.gov/?term=" + SearchTerm;

        Document doc = Jsoup.connect(url).get();
        Elements articles = doc.select(".full-docsum");

        for(Element result : articles){

            String title = result.select(".docsum-title").text();
            String author = result.select(".docsum-authors  ").text();
            String journal = result.select(".docsum-journal-citation").text();
            String pmid = result.select(".docsum-pmid").text();
            String link_article = "https://pubmed.ncbi.nlm.nih.gov/" + pmid;
            String summary = result.select(".full-view-snippet").text();

            listArticles.add(new ArticlePubMedDTO(title, author, journal, pmid, link_article, summary));
        }

        return listArticles;


    }

}
