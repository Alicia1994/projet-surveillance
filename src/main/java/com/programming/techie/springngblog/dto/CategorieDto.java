package com.programming.techie.springngblog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.programming.techie.springngblog.model.Categorie;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
public class CategorieDto {
    private Long id;
    private String name;

}
