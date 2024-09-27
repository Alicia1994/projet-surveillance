package com.programming.techie.springngblog.service.impl;

import com.programming.techie.springngblog.model.Categorie;
import com.programming.techie.springngblog.repository.CategorieRepository;
import com.programming.techie.springngblog.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class CategorieServiceImpl implements CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    @Override
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

}
