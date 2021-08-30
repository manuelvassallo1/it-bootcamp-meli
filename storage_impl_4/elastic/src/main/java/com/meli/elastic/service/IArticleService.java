package com.meli.elastic.service;

import com.meli.elastic.model.Article;

import java.util.List;
import java.util.Optional;

public interface IArticleService {
    public Article save(Article article);

    public List<Article> findAll();

    Optional<Article> findById(Integer id);

    String deleteById(Integer id);

    String updateArticle(Article article);
}
