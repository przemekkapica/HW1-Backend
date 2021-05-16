package com.example.demo.repository;

import com.example.demo.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface MovieRepository extends JpaRepository <MovieEntity, Integer> {

    @Query("select m from MovieEntity m " +
            "where (:startDate is null or m.date >= :startDate) " +
            "and (:endDate is null or m.date <= :endDate) " +
            "and (:genre is null or m.genre = :genre) " +
            "and (:ranking is null or m.ranking >= :ranking) " +
            "and (m.name like concat('%', :subName, '%'))")

    List<MovieEntity> getFilteredMovies(@Param("startDate") Date startDate,
                                        @Param("endDate") Date endDate,
                                        @Param("genre") String genre,
                                        @Param("ranking") Integer ranking,
                                        @Param("subName") String subName);

}
