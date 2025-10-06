package com.movie.movie.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.movie.dao.domain.MovieBO;

@Repository
public interface MovieRepository extends JpaRepository<MovieBO, Integer> {

}
