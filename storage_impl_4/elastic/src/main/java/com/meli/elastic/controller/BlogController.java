package com.meli.elastic.controller;

import com.meli.elastic.model.Article;
import com.meli.elastic.service.IArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BlogController {
    private final IArticleService service;

    @PostMapping("/article/new")
    public Article save(@RequestBody Article article) {
        return service.save(article);
    }

    @GetMapping("/articles")
    public List<Article> findAll() {
        return service.findAll();
    }

    @GetMapping("/article/{id}")
    public Optional<Article> findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id) {
        return service.deleteById(id);
    }

    @PutMapping("/update")
    public String updateArticle(@RequestBody Article article) {
        return service.updateArticle(article);
    }

}
