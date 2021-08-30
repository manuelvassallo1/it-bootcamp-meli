package com.meli.elastic.repository;

import com.meli.elastic.model.Article;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IArticleRepository extends ElasticsearchRepository<Article, Integer> {
    @Override
    @Query("{ 'query': { 'match_all': {} } }")
    List<Article> findAll();
}
