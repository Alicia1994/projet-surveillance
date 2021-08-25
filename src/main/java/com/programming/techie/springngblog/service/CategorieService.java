package com.programming.techie.springngblog.service;

import com.programming.techie.springngblog.dto.PostDto;
import com.programming.techie.springngblog.model.Categorie;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategorieService {

    List<Categorie> getAllCategories();
}
