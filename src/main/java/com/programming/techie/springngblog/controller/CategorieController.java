package com.programming.techie.springngblog.controller;

import com.programming.techie.springngblog.model.Categorie;
import com.programming.techie.springngblog.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @GetMapping("/all")
    public ResponseEntity<List<Categorie>> showAllCategories() {
        return new ResponseEntity<>(categorieService.getAllCategories(), HttpStatus.OK);
    }

}
