package com.meli.elastic.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Getter
@Setter
@Document(indexName = "blog")
public class Article {
    @Id
    private Integer id;
    private String title;

    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Author> authors;
}
