package com.programming.techie.springngblog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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
    @Column(name = "created_on", updatable = false, nullable = false)
    @CreationTimestamp
    private LocalDateTime createdOn;
    @Column(name = "updated_on")
    @UpdateTimestamp
    private LocalDateTime updatedOn;

    @ManyToOne
    @JsonIgnoreProperties("posts")
    private User user;


    public Post(){
    }

    @PreUpdate
    @PrePersist
    public void updateTimesStamps() {
        this.updatedOn = LocalDateTime.now();
        if (this.createdOn == null ){
            this.createdOn = LocalDateTime.now();
        }

    }



}
