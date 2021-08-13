package com.programming.techie.springngblog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
@Data
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column
    private String title;
    @Column
    @NotBlank
    private String username;
    @Lob
    @Column
    @NotEmpty
    private String content;
    @Column(name = "created_on")
    //private Date createdOn;
    private LocalDateTime createdOn;
    @Column
    private Date updatedOn;

    public Post(){
        this.createdOn = LocalDateTime.now();
       //this.createdOn = new Date(System.currentTimeMillis());
    }


}
