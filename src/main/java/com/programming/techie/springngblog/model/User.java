package com.programming.techie.springngblog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

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

    public User(){
        this.dateAccount = LocalDateTime.now();
    }

}

