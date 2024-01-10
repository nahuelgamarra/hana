package org.ngamarra.hana.service;

import org.ngamarra.hana.entity.Article;
import org.ngamarra.hana.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImp implements IArticleService{
    private ArticleRepository repository;
@Autowired
    public ArticleServiceImp(ArticleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Article> findAll() {
        return repository.findAll();
    }

    @Override
    public Article addArticle(Article articleDto) throws Exception {
        Optional article=  repository.findByName(articleDto.getName());
        if(article.isPresent()){
             throw new Exception();
        }else {
            return repository.save(articleDto);
        }
    }

}
