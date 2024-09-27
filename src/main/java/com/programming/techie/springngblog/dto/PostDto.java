package com.programming.techie.springngblog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.programming.techie.springngblog.model.Categorie;
import lombok.Data;
import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
public class PostDto {
    private Long id;
    private String content;
    private String title;
    private String username;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH-mm")
    private LocalDateTime createdOn;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH-mm")
    @Column
    private LocalDateTime updatedOn;
    private Categorie categorie;
    private String image;

}
