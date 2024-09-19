package com.api.stemProyect.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentDTO {

    private String id;
    private String author;
    private String journal;
    private String link;
    private String summary;
    private String title;

}
