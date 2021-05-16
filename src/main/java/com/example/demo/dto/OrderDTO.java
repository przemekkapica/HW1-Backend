package com.example.demo.dto;

import com.example.demo.entity.OrderEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
public class OrderDTO {

    private Integer id;

    private Integer movieId;

    private Date date;

    private BigDecimal netAmount;

    private double discount;

    private BigDecimal gross;


    public OrderDTO(OrderEntity orderEntity) {
        this.id = orderEntity.getId();
        this.date = orderEntity.getDate();
        this.discount = orderEntity.getDiscount();
        this.gross = orderEntity.getGross();
        this.movieId = orderEntity.getMovie().getId();
        this.netAmount = orderEntity.getNetAmount();

    }

}
