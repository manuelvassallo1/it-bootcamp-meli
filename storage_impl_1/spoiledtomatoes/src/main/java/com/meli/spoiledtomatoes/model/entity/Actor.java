package com.meli.spoiledtomatoes.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "actors")
public class Actor extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "rating")
    private Double rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "favorite_movie_id", nullable = false)
    private Movie favoriteMovie;

    @ManyToMany(mappedBy = "actors")
    private Set<Movie> actedMovies;

    @ManyToMany(mappedBy = "actors")
    private Set<Movie> actedEpisodes;

}
