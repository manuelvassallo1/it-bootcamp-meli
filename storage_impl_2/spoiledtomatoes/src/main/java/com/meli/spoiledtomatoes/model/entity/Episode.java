package com.meli.spoiledtomatoes.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "episodes")
public class Episode extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "number")
    private Integer number;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "rating")
    private Double rating;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "actor_episode",
            joinColumns = @JoinColumn(name = "episode_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private Set<Actor> actors;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "season_id", nullable = false)
    private Season season;

}
