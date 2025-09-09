package com.movie.movie.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.movie.dto.MovieDTO;
import com.movie.movie.service.MovieService;

@RestController
@RequestMapping("/covid")
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping("/{id}")
    public MovieDTO getMovieId(@PathVariable String id) {
        System.out.println("Hello Movies....id " + id);
        MovieDTO movie = movieService.getMovieById(id);
        return movie;
    }

    @GetMapping("/top5")
    public List<MovieDTO> getAllMovieById(@RequestParam(name = "by") String by) {
        System.out.println("getAllMovieTop5By....by " + by);
        List<MovieDTO> movieList = new ArrayList<>();
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId("2");
        movieDTO.setName("RAID2");
        movieList.add(movieDTO);
        return movieList;
    }

    @GetMapping("/total")
    public List<MovieDTO> getAllMovieByName(@RequestParam(name = "by") String by) {
        System.out.println("getAllMovieByName...." + by);
        List<MovieDTO> movieList = new ArrayList<>();
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId("3");
        movieDTO.setName("RAID3");
        movieList.add(movieDTO);
        return movieList;
    }
}
