package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name="movie_data")
public class MovieEntity {

    @Id
    private Integer id;

    private String name;

    private Date date;

    private double price;

    private Integer ranking;

    private String genre;

    public MovieEntity(Integer id) {
        this.id = id;
    }

}
