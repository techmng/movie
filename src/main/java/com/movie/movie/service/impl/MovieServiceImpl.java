package com.movie.movie.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.movie.movie.dto.MovieDTO;
import com.movie.movie.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
    @Override
    public List<MovieDTO> getAllMovies() {
        List<MovieDTO> movieList = new ArrayList<>();
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId("1");
        movieDTO.setName("RAID1");
        movieList.add(movieDTO);

        MovieDTO movieDTO2 = new MovieDTO();
        movieDTO2.setId("2");
        movieDTO2.setName("RAID2");
        movieList.add(movieDTO2);
        return movieList;
    }

    @Override
    public MovieDTO getMovieById(String id) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId("1");
        movieDTO.setName("RAID1");
        return movieDTO;
    }
}
