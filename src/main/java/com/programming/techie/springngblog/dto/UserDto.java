


package com.programming.techie.springngblog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.programming.techie.springngblog.model.Post;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserDto {

    private Long id;
    private String username;
    private String email;
    private String role;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH-mm")
    private LocalDateTime dateAccount;

}

