package com.api.stemProyect.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ArticlePubMedDTO {

    private String title;
    private String Author;
    private String Journal;
    private String pmid;
    private String Link;
    private String summary;

}