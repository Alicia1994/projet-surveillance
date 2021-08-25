package com.programming.techie.springngblog.repository;

import com.programming.techie.springngblog.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository  extends JpaRepository<Categorie, Long> {

}

