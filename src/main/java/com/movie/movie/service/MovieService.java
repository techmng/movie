package com.movie.movie.service;

import java.util.List;

import com.movie.movie.dto.MovieDTO;

public interface MovieService {
    public List<MovieDTO> getAllMovies();

    public MovieDTO getMovieById(String id);

    public void addMovie(String name);
}
