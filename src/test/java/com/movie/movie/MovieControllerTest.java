package com.movie.movie;

import com.movie.movie.dto.MovieDTO;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllMovies() throws Exception {
        // Arrange
        List<MovieDTO> expectedMovieList = new ArrayList<>();
        expectedMovieList.add(new MovieDTO("1", "RAID1"));
        expectedMovieList.add(new MovieDTO("2", "RAID2"));

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/moviess"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("RAID1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value("2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("RAID2"));
    }

    @Test
    public void testGetAllMovieById() throws Exception {
        // Arrange
        String id = "1";
        List<MovieDTO> expectedMovieList = new ArrayList<>();
        expectedMovieList.add(new MovieDTO("2", "RAID2"));

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/movies/{id}", id))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value("2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("RAID2"));
    }

    @Test
    public void testGetAllMovieByName() throws Exception {
        // Arrange
        String name = "RAID3";
        List<MovieDTO> expectedMovieList = new ArrayList<>();
        expectedMovieList.add(new MovieDTO("3", "RAID3"));

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/movies?name={name}", name)
                .param("name", name))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("RAID1"));
    }
}