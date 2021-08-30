package com.meli.spoiledtomatoes.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "movies")
@Getter
@Setter
public class Movie extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "awards")
    private Integer awards;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "length")
    private Integer length;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "actor_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> actors;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

    @OneToMany(mappedBy = "favoriteMovie", fetch = FetchType.LAZY)
    private Set<Actor> actorsFavorite;

}
