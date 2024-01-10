package org.ngamarra.hana.service;


import org.ngamarra.hana.entity.Article;

import java.util.List;

public interface IArticleService {
    List<Article> findAll();

    Article addArticle(Article articleDto) throws Exception;
}
