package com.meli.spoiledtomatoes.model.mapper;

import com.meli.spoiledtomatoes.model.dto.MovieDto;
import com.meli.spoiledtomatoes.model.entity.Genre;
import com.meli.spoiledtomatoes.model.entity.Movie;

import java.util.List;
import java.util.stream.Collectors;

public class MovieMapper {
    public static MovieDto toMovieDto(Movie movie) {

        if (movie == null) {
            return null;
        }

        Genre movieGenre = movie.getGenre();
        String genreName = null;

        if (movieGenre != null) {
            genreName = movieGenre.getName();
        }

        return MovieDto.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .awards(movie.getAwards())
                .length(movie.getLength())
                .rating(movie.getRating())
                .genre(genreName)
                .releaseDate(movie.getReleaseDate())
                .build();
    }


    public static List<MovieDto> toMoviesDto(List<Movie> movies) {
        return movies.stream()
                .map(MovieMapper::toMovieDto)
                .collect(Collectors.toList());
    }
}
