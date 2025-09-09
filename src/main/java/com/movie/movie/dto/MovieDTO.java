package com.movie.movie.dto;

import lombok.Data;

@Data
public class MovieDTO {
    String id;
    String name;

    public MovieDTO() {
    }

    public MovieDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }
}