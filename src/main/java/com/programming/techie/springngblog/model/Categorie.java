package com.programming.techie.springngblog.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table
@Data
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
