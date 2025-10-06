package com.movie.movie.dao.domain;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Data
@Entity
public class MovieBO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String name;

    public MovieBO() {
    }

    public MovieBO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public MovieBO(String name) {
        this.name = name;
    }
}