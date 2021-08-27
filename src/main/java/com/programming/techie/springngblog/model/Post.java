package com.programming.techie.springngblog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Data
@AllArgsConstructor
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   // @NotBlank
    @Column
    private String title;
    @Column
   // @NotBlank
    private String username;
    @Lob
    @Column
   // @NotEmpty
    private String content;
    @Column(name = "created_on", updatable = false, nullable = false)
    @CreationTimestamp
    private LocalDateTime createdOn;
    @Column(name = "updated_on")
    @UpdateTimestamp
    private LocalDateTime updatedOn;

    @OneToOne(fetch=FetchType.EAGER)
    private Categorie categorie;

   // @Column(length= 45, nullable = true)
    private String image;

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
