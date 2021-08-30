package com.meli.spoiledtomatoes.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "seasons")
@Getter
@Setter
public class Season extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "number")
    private Integer number;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "serie_id", nullable = false)
    private Serie serie;

    @OneToMany(mappedBy = "season", fetch = FetchType.LAZY)
    private Set<Episode> episodes;
}
