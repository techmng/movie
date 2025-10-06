package com.movie.movie.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.movie.dao.domain.MovieBO;
import com.movie.movie.dao.repo.MovieRepository;
import com.movie.movie.dto.MovieDTO;
import com.movie.movie.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void addMovie(String name) {
        movieRepository.save(new MovieBO(name));
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        List<MovieBO> movieBOList = (List<MovieBO>) movieRepository.findAll();
        return copyBOListToDTOList(movieBOList, new ArrayList<>());
    }

    @Override
    public MovieDTO getMovieById(String id) {
        MovieDTO movieDTO = null;
        try {
            Optional<MovieBO> movieBO = movieRepository.findById(Integer.parseInt(id));
            if (movieBO != null || !movieBO.isEmpty()) {
                movieDTO = new MovieDTO();
                movieDTO = copyBOToDTO(movieBO.get(), movieDTO);
            }

        } catch (Exception e) {
            return null;
        }
        return movieDTO;
    }

    private MovieDTO copyBOToDTO(MovieBO movieBO, MovieDTO movieDTO) {
        movieDTO.setId(movieBO.getId().toString());
        movieDTO.setName(movieBO.getName());
        return movieDTO;
    }

    private MovieBO copyDTOToBO(MovieDTO movieDTO, MovieBO movieBO) {
        movieBO.setId(Integer.parseInt(movieDTO.getId()));
        movieBO.setName(movieDTO.getName());
        return movieBO;
    }

    private List<MovieDTO> copyBOListToDTOList(List<MovieBO> movieBOList, List<MovieDTO> movieDTOList) {
        for (MovieBO movieBO : movieBOList) {
            MovieDTO movieDTO = new MovieDTO();
            movieDTO.setId(movieBO.getId().toString());
            movieDTO.setName(movieBO.getName());
            movieDTOList.add(movieDTO);
        }
        return movieDTOList;
    }

    private List<MovieBO> copyDTOListToBOList(List<MovieDTO> movieDTOList, List<MovieBO> movieBOList) {
        for (MovieDTO movieDTO : movieDTOList) {
            MovieBO movieBO = new MovieBO();
            movieBO.setId(Integer.parseInt(movieDTO.getId()));
            movieBO.setName(movieDTO.getName());
            movieBOList.add(movieBO);
        }
        return movieBOList;
    }
}
