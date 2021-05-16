package com.example.demo.api;

import com.example.demo.dto.MovieDTO;
import com.example.demo.dto.request.MovieRequestFilterDTO;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/movies")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/filter")
    private List<MovieDTO> getFiltered(@RequestBody MovieRequestFilterDTO movieRequestFilterDTO) {
        return movieService.getFilteredMovies(movieRequestFilterDTO);
    }
}
