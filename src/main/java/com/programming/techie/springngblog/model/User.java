package com.programming.techie.springngblog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Data
@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        }
)

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;

    private LocalDateTime dateAccount;

    private String role;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL
            //, mappedBy = "user"
    )
    private List<Post> postList;

    public User(){
        this.dateAccount = LocalDateTime.now();
    }

}

