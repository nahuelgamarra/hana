package org.ngamarra.hana.controller;

import org.ngamarra.hana.entity.Article;
import org.ngamarra.hana.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/article")
public class ArticleController {
    private IArticleService service;

    @Autowired
    public ArticleController(IArticleService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Article>> getAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Article> addArticle(@RequestBody Article articleDto){

        try {
            return new ResponseEntity<>(service.addArticle(articleDto),HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(articleDto,HttpStatus.CONFLICT);
        }
    }
}
