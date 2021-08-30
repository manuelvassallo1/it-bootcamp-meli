package com.meli.elastic.service;

import com.meli.elastic.model.Article;
import com.meli.elastic.repository.IArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService implements IArticleService {
    private final IArticleRepository repository;

    @Override
    public Article save(Article article) {
        return repository.save(article);
    }

    @Override
    public List<Article> findAll() {
        return repository.findAll();
    }

    public Optional<Article> findById(Integer id) {
        return repository.findById(id);
    }

    public String deleteById(Integer id) {
        repository.deleteById(id);
        return "Articulo eliminado";
    }

    public String updateArticle(Article article) {
        repository.save(article);
        return "Articulo editado";
    }
}
