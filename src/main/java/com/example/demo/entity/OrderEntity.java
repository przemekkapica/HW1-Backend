package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "order_data")
@Data
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private MovieEntity movie;

    private Date date;

    private BigDecimal netAmount;

    private double discount;

    private BigDecimal gross;

}
