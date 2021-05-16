package com.example.demo.dto;

import com.example.demo.entity.MovieEntity;
import lombok.Data;

import javax.persistence.Id;
import java.sql.Date;

@Data
public class MovieDTO {

    private int id;

    private String name;

    private Date date;

    private double price;

    private Integer ranking;

    private String genre;

    public MovieDTO(MovieEntity movieEntity) {
        this.id = movieEntity.getId();
        this.name = movieEntity.getName();
        this.date = movieEntity.getDate();
        this.price = movieEntity.getPrice();
        this.ranking = movieEntity.getRanking();
        this.genre = movieEntity.getGenre();
    }

}
