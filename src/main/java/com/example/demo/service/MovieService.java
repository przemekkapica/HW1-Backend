package com.example.demo.service;

import com.example.demo.dto.MovieDTO;
import com.example.demo.dto.request.MovieRequestFilterDTO;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public List<MovieDTO> getFilteredMovies(MovieRequestFilterDTO movieRequestFilterDTO) {

        var subName = movieRequestFilterDTO.getSubName() == null ? "" : movieRequestFilterDTO.getSubName();
        var movies =  movieRepository.getFilteredMovies(movieRequestFilterDTO.getStart(), movieRequestFilterDTO.getEnd(), movieRequestFilterDTO.getGenre(),
                movieRequestFilterDTO.getRanking(), subName);

        return movies.stream()
                .map(MovieDTO::new)
                .collect(Collectors.toList());
    }

}
