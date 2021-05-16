package com.example.demo.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
public class UpdateOrderDTOCmd {

    private Integer id;

    private Integer movieId;

    private Date date;

    private BigDecimal netAmount;

    private double discount;

    private BigDecimal gross;

}
