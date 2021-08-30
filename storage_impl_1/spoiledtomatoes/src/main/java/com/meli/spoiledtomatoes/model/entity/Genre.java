package com.meli.spoiledtomatoes.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "genres")
public class Genre extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "ranking")
    private Integer ranking;

    @Column(name = "active")
    private Byte active;

    @OneToMany(mappedBy = "genre")
    private Set<Movie> moviesByGenre;

    @OneToMany(mappedBy = "genre")
    private Set<Serie> seriesByGenre;

}
